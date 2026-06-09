#!/usr/bin/env python3
"""Detailed analysis of partial benchmark results from fix_reports/ and output/.

Outputs
-------
CSV (repo root):
  * results_detailed.csv     full per-(model,dataset,direction) breakdown
  * results_leaderboard.csv  per-model aggregate across all benchmarks
  * results_partial.csv      compact summary (kept for backward compatibility)

Plots (plots/), each saved as its own file:
  01 pass_rate_attempt1_vs_repair   02 error_breakdown_per_model
  03 heatmap_attempt1               04 heatmap_after_repair
  05 compile_vs_pass                06 failure_composition
  07 repair_effectiveness           08 model_leaderboard

Outcome model: a translation must compile -> run -> produce correct output.
  compile error  = did not compile / parse
  runtime error  = compiled but crashed
  incorrect      = compiled & ran but wrong output
  "only compiles" (compiled but not passing) = runtime + incorrect
"""

import json
from pathlib import Path

import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
import seaborn as sns
import pandas as pd

BASE = Path(__file__).parent.resolve()
FIX_REPORTS = BASE / "fix_reports"
OUTPUT_DIR = BASE / "output"
PLOTS_DIR = BASE / "plots"

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


# ---------------------------------------------------------------------------
# Loading
# ---------------------------------------------------------------------------

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
            "rem_compile":   compile_e,
            "rem_runtime":   runtime_e,
            "rem_incorrect": incorrect_e,
        })
    return pd.DataFrame(rows)


# ---------------------------------------------------------------------------
# Derived tables
# ---------------------------------------------------------------------------

_KEYS = ["model", "dataset", "src", "tgt"]


def build_detailed_df(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
    """One rich row per (model, dataset, direction) with the full breakdown."""
    rep_cols = ["repaired", "repaired_pass", "rem_compile", "rem_runtime", "rem_incorrect"]
    if df2.empty:
        m = df1.copy()
        for c in rep_cols:
            m[c] = 0
    else:
        m = df1.merge(df2[_KEYS + rep_cols], on=_KEYS, how="left")
        for c in rep_cols:
            m[c] = m[c].fillna(0).astype(int)

    m = m.rename(columns={
        "pass": "pass1", "pass_rate": "pass1_rate",
        "compile": "compile_err1", "runtime": "runtime_err1", "incorrect": "incorrect_err1",
    })

    m["failed1"]            = m["compile_err1"] + m["runtime_err1"] + m["incorrect_err1"]
    m["compiled1"]          = m["total"] - m["compile_err1"]
    m["compile_rate1"]      = m["compiled1"] / m["total"] * 100
    m["compiled_not_pass1"] = m["runtime_err1"] + m["incorrect_err1"]
    m["final_pass"]         = m["pass1"] + m["repaired_pass"]
    m["final_rate"]         = m["final_pass"] / m["total"] * 100
    m["repaired_rate"]      = m.apply(
        lambda r: (r["repaired_pass"] / r["repaired"] * 100) if r["repaired"] else float("nan"),
        axis=1)
    m["delta_rate"]         = m["final_rate"] - m["pass1_rate"]

    cols = [
        "model", "dataset", "direction", "total",
        "pass1", "pass1_rate",
        "compile_err1", "runtime_err1", "incorrect_err1",
        "compiled1", "compile_rate1", "compiled_not_pass1", "failed1",
        "repaired", "repaired_pass", "repaired_rate",
        "rem_compile", "rem_runtime", "rem_incorrect",
        "final_pass", "final_rate", "delta_rate",
    ]
    out = m[cols].copy()
    for c in ["pass1_rate", "compile_rate1", "repaired_rate", "final_rate", "delta_rate"]:
        out[c] = out[c].round(2)
    return out.sort_values(["model", "dataset", "direction"]).reset_index(drop=True)


def build_leaderboard_df(det: pd.DataFrame) -> pd.DataFrame:
    """Per-model aggregate across all benchmarks (snippet-weighted)."""
    g = det.groupby("model", as_index=False).agg(
        benchmarks=("total", "size"),
        snippets=("total", "sum"),
        pass1=("pass1", "sum"),
        compiled1=("compiled1", "sum"),
        repaired=("repaired", "sum"),
        repaired_pass=("repaired_pass", "sum"),
        final_pass=("final_pass", "sum"),
    )
    g["pass1_rate"]    = (g["pass1"] / g["snippets"] * 100).round(2)
    g["compile_rate"]  = (g["compiled1"] / g["snippets"] * 100).round(2)
    g["final_rate"]    = (g["final_pass"] / g["snippets"] * 100).round(2)
    g["repair_gain"]   = (g["final_rate"] - g["pass1_rate"]).round(2)
    g["repaired_rate"] = (g["repaired_pass"] / g["repaired"].where(g["repaired"] > 0) * 100).round(2)
    cols = ["model", "benchmarks", "snippets", "pass1_rate", "compile_rate",
            "repaired", "repaired_pass", "repaired_rate", "final_rate", "repair_gain"]
    return g[cols].sort_values("final_rate", ascending=False).reset_index(drop=True)


def build_summary_df(det: pd.DataFrame) -> pd.DataFrame:
    """Compact summary (backward-compatible columns of the old results_partial.csv)."""
    out = det[["model", "dataset", "direction", "total", "pass1", "pass1_rate",
               "repaired", "repaired_pass", "repaired_rate",
               "final_pass", "final_rate"]].copy()
    return out


def print_table(det: pd.DataFrame) -> None:
    header = (f"{'Model':<16} {'Dataset':<9} {'Direction':<13} "
              f"{'Tot':>4} {'Pass1':>5} {'Rate1':>6} {'Cmpl%':>6} {'OnlyC':>5}  "
              f"{'Rep':>4} {'RepP':>5} {'Final':>5} {'FinalR':>7} {'Δpp':>6}")
    print(header)
    print("-" * len(header))
    for _, r in det.iterrows():
        rr = "" if pd.isna(r["repaired_rate"]) else f"{r['repaired_rate']:.0f}%"
        print(f"{r['model']:<16} {r['dataset']:<9} {r['direction']:<13} "
              f"{r['total']:>4} {r['pass1']:>5} {r['pass1_rate']:>5.1f}% "
              f"{r['compile_rate1']:>5.1f}% {r['compiled_not_pass1']:>5}  "
              f"{r['repaired']:>4} {r['repaired_pass']:>5} {r['final_pass']:>5} "
              f"{r['final_rate']:>6.1f}% {r['delta_rate']:>+5.1f}")
    print()


# ---------------------------------------------------------------------------
# Plot helpers
# ---------------------------------------------------------------------------

def _save(fig, name: str) -> None:
    PLOTS_DIR.mkdir(exist_ok=True)
    path = PLOTS_DIR / name
    fig.savefig(path, dpi=200, bbox_inches="tight")
    plt.close(fig)
    print(f"Saved → {path}")


def _benches(df: pd.DataFrame):
    return sorted(df["bench"].unique())


# 01 -------------------------------------------------------------------------
def fig_pass_rate(df1: pd.DataFrame, df2: pd.DataFrame) -> None:
    pivot1 = df1.pivot(index="bench", columns="model", values="pass_rate")
    pivot2 = None
    if not df2.empty:
        merged = df1.merge(df2[_KEYS + ["repaired_pass"]], on=_KEYS, how="left")
        merged["repaired_pass"] = merged["repaired_pass"].fillna(0)
        merged["final_rate"] = (merged["pass"] + merged["repaired_pass"]) / merged["total"] * 100
        pivot2 = merged.pivot(index="bench", columns="model", values="final_rate")

    fig, ax = plt.subplots(figsize=(18, 8))
    x = range(len(pivot1))
    models = pivot1.columns.tolist()
    n = len(models)
    width = 0.35 if pivot2 is not None else 0.6
    colors = plt.rcParams["axes.prop_cycle"].by_key()["color"]

    for i, model in enumerate(models):
        offset = (i - n / 2 + 0.5) * (width * (2 if pivot2 is not None else 1) + 0.05)
        bars1 = ax.bar([xi + offset for xi in x], pivot1[model], width=width,
                       color=colors[i % len(colors)], alpha=0.5, edgecolor="white",
                       label=f"{model} (attempt 1)")
        ax.bar_label(bars1, fmt="%.0f", fontsize=7, padding=2)
        if pivot2 is not None and model in pivot2.columns:
            bars2 = ax.bar([xi + offset + width for xi in x], pivot2[model], width=width,
                           color=colors[i % len(colors)], alpha=1.0, edgecolor="white",
                           label=f"{model} (after repair)")
            ax.bar_label(bars2, fmt="%.0f", fontsize=7, padding=2)

    ax.set_xticks(list(x))
    ax.set_xticklabels(pivot1.index.tolist(), rotation=20, ha="right", fontsize=10)
    ax.set_title("Pass Rate — Attempt 1 (faded) vs After Repair (solid)",
                 fontweight="bold", fontsize=15)
    ax.set_ylabel("Pass Rate (%)")
    ax.set_ylim(0, 110)
    ax.axhline(50, color="gray", linestyle="--", linewidth=0.8, alpha=0.5)
    ax.legend(bbox_to_anchor=(1.01, 1), loc="upper left", fontsize=8)
    ax.grid(axis="y", alpha=0.3)
    _save(fig, "01_pass_rate_attempt1_vs_repair.png")


# 02 -------------------------------------------------------------------------
def fig_error_breakdown(df1: pd.DataFrame) -> None:
    models = sorted(df1["model"].unique())
    fig, axes = plt.subplots(1, len(models), figsize=(5 * len(models), 6), squeeze=False)
    axes = axes[0]
    for ax, model in zip(axes, models):
        sub = df1[df1["model"] == model].copy().sort_values("bench")
        benches = sub["bench"].tolist()
        x = range(len(benches))
        bottom = [0] * len(benches)
        for kind in ["pass", "incorrect", "runtime", "compile"]:
            vals = sub[kind].tolist()
            ax.bar(x, vals, bottom=bottom, color=ERROR_COLORS[kind],
                   label=kind, edgecolor="white", linewidth=0.4)
            bottom = [b + v for b, v in zip(bottom, vals)]
        ax.set_title(model, fontweight="bold", fontsize=11)
        ax.set_xticks(list(x))
        ax.set_xticklabels(benches, rotation=30, ha="right", fontsize=7)
        ax.set_ylabel("Snippets", fontsize=9)
        ax.grid(axis="y", alpha=0.3)
    patches = [mpatches.Patch(color=c, label=k) for k, c in ERROR_COLORS.items()]
    fig.legend(handles=patches, title="Outcome", bbox_to_anchor=(1.0, 0.95),
               loc="upper left", fontsize=9)
    fig.suptitle("Outcome breakdown per model (attempt 1)", fontweight="bold", fontsize=14)
    _save(fig, "02_error_breakdown_per_model.png")


# 03 / 04 --------------------------------------------------------------------
def _heatmap(pivot: pd.DataFrame, title: str, name: str) -> None:
    fig, ax = plt.subplots(figsize=(max(8, 1.5 * pivot.shape[1]), 0.9 * pivot.shape[0] + 2))
    sns.heatmap(pivot, ax=ax, annot=True, fmt=".0f", cmap="RdYlGn",
                vmin=0, vmax=100, linewidths=0.5, cbar_kws={"label": "Pass Rate (%)"})
    ax.set_title(title, fontweight="bold", fontsize=14)
    ax.set_xlabel(""); ax.set_ylabel("")
    ax.tick_params(axis="x", rotation=30, labelsize=10)
    ax.tick_params(axis="y", labelsize=10)
    _save(fig, name)


def fig_heatmaps(df1: pd.DataFrame, df2: pd.DataFrame) -> None:
    _heatmap(df1.pivot(index="model", columns="bench", values="pass_rate"),
             "Attempt 1 — Pass Rate (%)", "03_heatmap_attempt1.png")
    if not df2.empty:
        merged = df1.merge(df2[_KEYS + ["repaired_pass"]], on=_KEYS, how="left")
        merged["repaired_pass"] = merged["repaired_pass"].fillna(0)
        merged["final_rate"] = (merged["pass"] + merged["repaired_pass"]) / merged["total"] * 100
        _heatmap(merged.pivot(index="model", columns="bench", values="final_rate"),
                 "After Repair — Pass Rate (%)", "04_heatmap_after_repair.png")


# 05 -------------------------------------------------------------------------
def fig_compile_vs_pass(det: pd.DataFrame) -> None:
    """The gap between 'compiles' and 'passes' = code that only compiles."""
    models = sorted(det["model"].unique())
    fig, axes = plt.subplots(1, len(models), figsize=(5 * len(models), 6),
                             squeeze=False, sharey=True)
    axes = axes[0]
    for ax, model in zip(axes, models):
        sub = det[det["model"] == model].sort_values("direction")
        sub = sub.assign(bench=sub["dataset"] + "\n" + sub["direction"]).sort_values("bench")
        benches = sub["bench"].tolist()
        x = range(len(benches))
        ax.bar([xi - 0.2 for xi in x], sub["compile_rate1"], width=0.4,
               color="#90caf9", edgecolor="white", label="compiles")
        ax.bar([xi + 0.2 for xi in x], sub["pass1_rate"], width=0.4,
               color="#1565c0", edgecolor="white", label="passes")
        ax.set_title(model, fontweight="bold", fontsize=11)
        ax.set_xticks(list(x))
        ax.set_xticklabels(benches, rotation=30, ha="right", fontsize=7)
        ax.set_ylim(0, 105)
        ax.grid(axis="y", alpha=0.3)
    axes[0].set_ylabel("Rate (%)")
    axes[-1].legend(bbox_to_anchor=(1.01, 1), loc="upper left", fontsize=9)
    fig.suptitle("Compiles vs Passes — the gap is code that compiles but is wrong/crashes",
                 fontweight="bold", fontsize=14)
    _save(fig, "05_compile_vs_pass.png")


# 06 -------------------------------------------------------------------------
def fig_failure_composition(det: pd.DataFrame) -> None:
    """Of the FAILURES, what fraction are compile / runtime / incorrect."""
    models = sorted(det["model"].unique())
    fig, axes = plt.subplots(1, len(models), figsize=(5 * len(models), 6),
                             squeeze=False, sharey=True)
    axes = axes[0]
    for ax, model in zip(axes, models):
        sub = det[det["model"] == model].copy()
        sub = sub.assign(bench=sub["dataset"] + "\n" + sub["direction"]).sort_values("bench")
        benches = sub["bench"].tolist()
        x = range(len(benches))
        denom = sub["failed1"].replace(0, pd.NA)
        bottom = [0] * len(benches)
        for kind, col in [("compile", "compile_err1"), ("runtime", "runtime_err1"),
                          ("incorrect", "incorrect_err1")]:
            frac = (sub[col] / denom * 100).fillna(0).tolist()
            ax.bar(x, frac, bottom=bottom, color=ERROR_COLORS[kind],
                   label=kind, edgecolor="white", linewidth=0.4)
            bottom = [b + v for b, v in zip(bottom, frac)]
        ax.set_title(model, fontweight="bold", fontsize=11)
        ax.set_xticks(list(x))
        ax.set_xticklabels(benches, rotation=30, ha="right", fontsize=7)
        ax.set_ylim(0, 100)
        ax.grid(axis="y", alpha=0.3)
    axes[0].set_ylabel("% of failures")
    patches = [mpatches.Patch(color=ERROR_COLORS[k], label=k)
               for k in ["compile", "runtime", "incorrect"]]
    axes[-1].legend(handles=patches, title="Failure type", bbox_to_anchor=(1.01, 1),
                    loc="upper left", fontsize=9)
    fig.suptitle("Failure composition — why translations fail (normalised per benchmark)",
                 fontweight="bold", fontsize=14)
    _save(fig, "06_failure_composition.png")


# 07 -------------------------------------------------------------------------
def fig_repair_effectiveness(det: pd.DataFrame) -> None:
    """Percentage-point pass-rate gain from the repair stage (model x benchmark)."""
    d = det.copy()
    d["bench"] = d["dataset"] + "\n" + d["direction"]
    pivot = d.pivot(index="model", columns="bench", values="delta_rate")
    vmax = max(1.0, float(pivot.abs().max().max()))
    fig, ax = plt.subplots(figsize=(max(8, 1.6 * pivot.shape[1]), 0.9 * pivot.shape[0] + 2))
    sns.heatmap(pivot, ax=ax, annot=True, fmt=".1f", cmap="RdYlGn",
                center=0, vmin=-vmax, vmax=vmax, linewidths=0.5,
                cbar_kws={"label": "Δ pass rate (pp)"})
    ax.set_title("Repair effectiveness — pass-rate gain from repair (pp)",
                 fontweight="bold", fontsize=14)
    ax.set_xlabel(""); ax.set_ylabel("")
    ax.tick_params(axis="x", rotation=30, labelsize=10)
    _save(fig, "07_repair_effectiveness.png")


# 08 -------------------------------------------------------------------------
def fig_leaderboard(lb: pd.DataFrame) -> None:
    lb = lb.sort_values("final_rate")
    y = range(len(lb))
    fig, ax = plt.subplots(figsize=(10, 0.7 * len(lb) + 2))
    ax.barh([yi + 0.2 for yi in y], lb["compile_rate"], height=0.18,
            color="#90caf9", label="compile rate")
    ax.barh([yi for yi in y], lb["pass1_rate"], height=0.18,
            color="#1565c0", label="pass@1")
    ax.barh([yi - 0.2 for yi in y], lb["final_rate"], height=0.18,
            color="#4caf50", label="final (after repair)")
    ax.set_yticks(list(y))
    ax.set_yticklabels(lb["model"])
    ax.set_xlabel("Rate (%) — snippet-weighted across all benchmarks")
    ax.set_xlim(0, 105)
    ax.set_title("Model leaderboard", fontweight="bold", fontsize=14)
    ax.legend(loc="lower right", fontsize=9)
    ax.grid(axis="x", alpha=0.3)
    for yi, (_, r) in zip(y, lb.iterrows()):
        ax.text(r["final_rate"] + 1, yi - 0.2, f"{r['final_rate']:.0f}%",
                va="center", fontsize=8)
    _save(fig, "08_model_leaderboard.png")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main() -> None:
    sns.set_theme(style="whitegrid", font_scale=0.95)
    df1 = load_attempt1()
    df2 = load_attempt2()

    if df1.empty:
        print("No error JSON files found in fix_reports/. Run tests first.")
        return

    detailed   = build_detailed_df(df1, df2)
    leaderboard = build_leaderboard_df(detailed)

    print_table(detailed)
    print("Leaderboard (snippet-weighted across benchmarks):")
    print(leaderboard.to_string(index=False))
    print()

    detailed.to_csv(BASE / "results_detailed.csv", index=False)
    leaderboard.to_csv(BASE / "results_leaderboard.csv", index=False)
    build_summary_df(detailed).to_csv(BASE / "results_partial.csv", index=False)
    for name in ("results_detailed.csv", "results_leaderboard.csv", "results_partial.csv"):
        print(f"Saved → {BASE / name}")
    print()

    fig_pass_rate(df1, df2)
    fig_error_breakdown(df1)
    fig_heatmaps(df1, df2)
    fig_compile_vs_pass(detailed)
    fig_failure_composition(detailed)
    if not df2.empty:
        fig_repair_effectiveness(detailed)
    fig_leaderboard(leaderboard)


if __name__ == "__main__":
    main()
