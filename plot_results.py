#!/usr/bin/env python3
"""Plot partial benchmark results from fix_reports/ and output/ directories."""

import json
from pathlib import Path

import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
import seaborn as sns
import pandas as pd

BASE = Path(__file__).parent.resolve()
FIX_REPORTS = BASE / "fix_reports"
OUTPUT_DIR = BASE / "output"

DATASET_SIZES = {
    ("codenet", "Java",   "Python"): 201,
    ("codenet", "Python", "Java"):   200,
    ("avatar",  "Java",   "Python"): 249,
    ("avatar",  "Python", "Java"):   250,
    ("evalplus","Python", "Java"):   164,
}

ERROR_COLORS = {
    "pass":      "#4caf50",
    "incorrect": "#ff9800",
    "runtime":   "#f44336",
    "compile":   "#9c27b0",
}


_LANG_EXT = {"Java": ".java", "Python": ".py", "C": ".c", "C++": ".cpp", "Go": ".go"}


def _count_repaired(label: str, dataset: str, src: str, tgt: str) -> int:
    d = OUTPUT_DIR / f"{label}_IO_1" / dataset / src / tgt
    if not d.exists():
        return 0
    ext = _LANG_EXT.get(tgt, "")
    return sum(1 for f in d.iterdir() if f.suffix == ext)


def load_attempt1() -> pd.DataFrame:
    rows = []
    for f in sorted(FIX_REPORTS.glob("*_errors_*_1.json")):
        stem = f.stem[: f.stem.rfind("_")]          # drop trailing _1
        left, rest = stem.split("_errors_from_")
        src, tgt = rest.split("_to_")
        sep = left.rfind("_")
        model, dataset = left[:sep], left[sep + 1:]

        with open(f) as fp:
            d = json.load(fp)
        compile_e   = len(d.get("compile",   []))
        runtime_e   = len(d.get("runtime",   []))
        incorrect_e = len(d.get("incorrect", []))
        total_e = compile_e + runtime_e + incorrect_e

        total  = DATASET_SIZES.get((dataset, src, tgt), 0)
        passed = max(0, total - total_e)

        rows.append({
            "model":     model,
            "dataset":   dataset,
            "src":       src,
            "tgt":       tgt,
            "direction": f"{src}→{tgt}",
            "bench":     f"{dataset}\n{src}→{tgt}",
            "total":     total,
            "pass":      passed,
            "incorrect": incorrect_e,
            "runtime":   runtime_e,
            "compile":   compile_e,
            "pass_rate": passed / total * 100 if total else 0,
        })
    return pd.DataFrame(rows)


def load_attempt2() -> pd.DataFrame:
    """Load retest (post-repair) results. Only rows that have been retested."""
    rows = []
    # filename: <label>_IO_1_<dataset>_errors_from_<src>_to_<tgt>_2.json
    for f in sorted(FIX_REPORTS.glob("*_IO_1_*_errors_*_2.json")):
        stem = f.stem[: f.stem.rfind("_")]          # drop _2
        left, rest = stem.split("_errors_from_")
        src, tgt = rest.split("_to_")
        # left = <label>_IO_1_<dataset>
        # strip _IO_1 suffix to get label and dataset
        io_sep = left.index("_IO_1_")
        label   = left[:io_sep]
        dataset = left[io_sep + len("_IO_1_"):]

        with open(f) as fp:
            d = json.load(fp)
        compile_e   = len(d.get("compile",   []))
        runtime_e   = len(d.get("runtime",   []))
        incorrect_e = len(d.get("incorrect", []))
        total_e2 = compile_e + runtime_e + incorrect_e

        repaired = _count_repaired(label, dataset, src, tgt)
        repaired_pass = max(0, repaired - total_e2)

        rows.append({
            "model":         label,
            "dataset":       dataset,
            "src":           src,
            "tgt":           tgt,
            "direction":     f"{src}→{tgt}",
            "bench":         f"{dataset}\n{src}→{tgt}",
            "repaired":      repaired,
            "repaired_pass": repaired_pass,
            "compile":       compile_e,
            "runtime":       runtime_e,
            "incorrect":     incorrect_e,
        })
    return pd.DataFrame(rows)


def print_table(df1: pd.DataFrame, df2: pd.DataFrame) -> None:
    header = (f"{'Model':<20} {'Dataset':<10} {'Direction':<13} "
              f"{'Total':>6} {'Pass1':>6} {'Rate1':>7}  "
              f"{'Repaired':>9} {'PassR':>6} {'RateR':>7}  "
              f"{'FinalPass':>10} {'FinalRate':>10}")
    print(header)
    print("-" * len(header))

    for _, r in df1.iterrows():
        key = (r["model"], r["dataset"], r["src"], r["tgt"])
        match = df2[
            (df2["model"] == key[0]) & (df2["dataset"] == key[1]) &
            (df2["src"] == key[2]) & (df2["tgt"] == key[3])
        ]
        total = r["total"]
        pass1 = r["pass"]
        rate1 = r["pass_rate"]

        if not match.empty:
            m = match.iloc[0]
            repaired      = m["repaired"]
            repaired_pass = m["repaired_pass"]
            final_pass    = pass1 + repaired_pass
            final_rate    = final_pass / total * 100 if total else 0
            rep_rate      = repaired_pass / repaired * 100 if repaired else 0
            print(f"{r['model']:<20} {r['dataset']:<10} {r['direction']:<13} "
                  f"{total:>6} {pass1:>6} {rate1:>6.1f}%  "
                  f"{repaired:>9} {repaired_pass:>6} {rep_rate:>6.1f}%  "
                  f"{final_pass:>10} {final_rate:>9.1f}%")
        else:
            print(f"{r['model']:<20} {r['dataset']:<10} {r['direction']:<13} "
                  f"{total:>6} {pass1:>6} {rate1:>6.1f}%  "
                  f"{'—':>9} {'—':>6} {'—':>7}  "
                  f"{'—':>10} {'—':>10}")
    print()


def plot_pass_rates(df1: pd.DataFrame, df2: pd.DataFrame, ax: plt.Axes) -> None:
    pivot1 = df1.pivot(index="bench", columns="model", values="pass_rate")

    # Build final-pass-rate pivot from df2 merged with df1
    if not df2.empty:
        merged = df1.merge(df2[["model", "dataset", "src", "tgt", "repaired_pass"]],
                           on=["model", "dataset", "src", "tgt"], how="left")
        merged["repaired_pass"] = merged["repaired_pass"].fillna(0)
        merged["final_pass"] = merged["pass"] + merged["repaired_pass"]
        merged["final_rate"] = merged["final_pass"] / merged["total"] * 100
        pivot2 = merged.pivot(index="bench", columns="model", values="final_rate")
    else:
        pivot2 = None

    x = range(len(pivot1))
    models = pivot1.columns.tolist()
    n = len(models)
    width = 0.35 if pivot2 is not None else 0.6
    colors = plt.rcParams["axes.prop_cycle"].by_key()["color"]

    for i, model in enumerate(models):
        offset = (i - n / 2 + 0.5) * (width * (2 if pivot2 is not None else 1) + 0.05)
        bars1 = ax.bar([xi + offset for xi in x], pivot1[model],
                       width=width, color=colors[i], alpha=0.5,
                       edgecolor="white", label=f"{model} (attempt 1)")
        ax.bar_label(bars1, fmt="%.0f%%", fontsize=8, padding=2)

        if pivot2 is not None and model in pivot2.columns:
            bars2 = ax.bar([xi + offset + width for xi in x], pivot2[model],
                           width=width, color=colors[i], alpha=1.0,
                           edgecolor="white", label=f"{model} (after repair)")
            ax.bar_label(bars2, fmt="%.0f%%", fontsize=8, padding=2)

    ax.set_xticks(list(x))
    ax.set_xticklabels(pivot1.index.tolist(), rotation=30, ha="right", fontsize=11)
    ax.set_title("Pass Rate — Attempt 1 (faded) vs After Repair (solid)",
                 fontweight="bold", fontsize=15)
    ax.set_ylabel("Pass Rate (%)", fontsize=12)
    ax.set_ylim(0, 110)
    ax.axhline(50, color="gray", linestyle="--", linewidth=0.8, alpha=0.5)
    ax.legend(bbox_to_anchor=(1.01, 1), loc="upper left", fontsize=10)
    ax.grid(axis="y", alpha=0.3)


def plot_error_breakdown(df: pd.DataFrame, axes) -> None:
    models = sorted(df["model"].unique())
    for ax, model in zip(axes, models):
        sub = df[df["model"] == model].copy().sort_values("bench")
        benches = sub["bench"].tolist()
        x = range(len(benches))
        bottom = [0] * len(benches)
        for kind in ["pass", "incorrect", "runtime", "compile"]:
            vals = sub[kind].tolist()
            ax.bar(x, vals, bottom=bottom, color=ERROR_COLORS[kind],
                   label=kind, edgecolor="white", linewidth=0.4)
            bottom = [b + v for b, v in zip(bottom, vals)]

        ax.set_title(model, fontweight="bold", fontsize=10)
        ax.set_xticks(list(x))
        ax.set_xticklabels(benches, rotation=30, ha="right", fontsize=7)
        ax.set_ylabel("Snippets", fontsize=9)
        ax.grid(axis="y", alpha=0.3)

    patches = [mpatches.Patch(color=c, label=k) for k, c in ERROR_COLORS.items()]
    axes[-1].legend(handles=patches, title="Outcome", bbox_to_anchor=(1.01, 1),
                    loc="upper left", fontsize=8)


def plot_heatmap(df1: pd.DataFrame, df2: pd.DataFrame, fig, gs_row, ncols: int) -> None:
    titles  = ["Attempt 1 — Pass Rate (%)"]
    pivots  = [df1.pivot(index="model", columns="bench", values="pass_rate")]

    if not df2.empty:
        merged = df1.merge(df2[["model", "dataset", "src", "tgt", "repaired_pass"]],
                           on=["model", "dataset", "src", "tgt"], how="left")
        merged["repaired_pass"] = merged["repaired_pass"].fillna(0)
        merged["final_pass"] = merged["pass"] + merged["repaired_pass"]
        merged["final_rate"] = merged["final_pass"] / merged["total"] * 100
        pivots.append(merged.pivot(index="model", columns="bench", values="final_rate"))
        titles.append("After Repair — Pass Rate (%)")

    n = len(pivots)
    axes = [fig.add_subplot(gs_row[i]) for i in range(n)]
    # hide any unused axes
    for ax in axes[n:]:
        ax.set_visible(False)

    for ax, pivot, title in zip(axes, pivots, titles):
        sns.heatmap(pivot, ax=ax, annot=True, fmt=".0f", cmap="RdYlGn",
                    vmin=0, vmax=100, linewidths=0.5,
                    cbar_kws={"label": "Pass Rate (%)"})
        ax.set_title(title, fontweight="bold", fontsize=14)
        ax.set_xlabel("")
        ax.set_ylabel("")
        ax.tick_params(axis="x", rotation=30, labelsize=11)
        ax.tick_params(axis="y", labelsize=11)


def build_summary_df(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
    rows = []
    for _, r in df1.iterrows():
        key = (r["model"], r["dataset"], r["src"], r["tgt"])
        match = df2[
            (df2["model"] == key[0]) & (df2["dataset"] == key[1]) &
            (df2["src"] == key[2]) & (df2["tgt"] == key[3])
        ]
        total = r["total"]
        pass1 = r["pass"]
        rate1 = r["pass_rate"]

        if not match.empty:
            m = match.iloc[0]
            repaired      = int(m["repaired"])
            repaired_pass = int(m["repaired_pass"])
            final_pass    = pass1 + repaired_pass
            final_rate    = final_pass / total * 100 if total else 0
            rep_rate      = repaired_pass / repaired * 100 if repaired else 0
        else:
            repaired = repaired_pass = final_pass = 0
            final_rate = rep_rate = float("nan")

        rows.append({
            "model":        r["model"],
            "dataset":      r["dataset"],
            "direction":    r["direction"],
            "total":        total,
            "pass1":        pass1,
            "pass1_rate":   round(rate1, 2),
            "repaired":     repaired,
            "repaired_pass": repaired_pass,
            "repaired_rate": round(rep_rate, 2) if not pd.isna(rep_rate) else "",
            "final_pass":   final_pass,
            "final_rate":   round(final_rate, 2) if not pd.isna(final_rate) else "",
        })
    return pd.DataFrame(rows)


def main() -> None:
    sns.set_theme(style="whitegrid", font_scale=0.95)
    df1 = load_attempt1()
    df2 = load_attempt2()

    if df1.empty:
        print("No error JSON files found in fix_reports/. Run tests first.")
        return

    print_table(df1, df2)

    # Save CSV
    csv_out = BASE / "results_partial.csv"
    build_summary_df(df1, df2).to_csv(csv_out, index=False)
    print(f"Saved → {csv_out}")

    n_models = df1["model"].nunique()
    has_repair = not df2.empty

    fig = plt.figure(figsize=(28, 26 if has_repair else 20))
    fig.suptitle("Lost in Translation — Partial Benchmark Results",
                 fontsize=20, fontweight="bold", y=0.99)

    nrows = 3
    gs = fig.add_gridspec(nrows, max(n_models, 2), hspace=0.7, wspace=0.45,
                          height_ratios=[1.1, 1.0, 1.1])

    # Row 0: pass rate bar chart (attempt 1 vs after repair)
    ax_pass = fig.add_subplot(gs[0, :])
    plot_pass_rates(df1, df2, ax_pass)

    # Row 1: error breakdown per model (attempt 1)
    axes_bd = [fig.add_subplot(gs[1, i]) for i in range(n_models)]
    plot_error_breakdown(df1, axes_bd)

    # Row 2: heatmaps (attempt 1, and after repair side-by-side if available)
    n_heat = 2 if has_repair else 1
    half = max(n_models, 2) // 2
    gs_heat = [gs[2, :half], gs[2, half:]] if has_repair else [gs[2, :]]
    plot_heatmap(df1, df2, fig, gs_heat, n_heat)

    png_out = BASE / "results_partial.png"
    plt.savefig(png_out, dpi=200, bbox_inches="tight")
    print(f"Saved → {png_out}")
    plt.show()


if __name__ == "__main__":
    main()
