#!/usr/bin/env python3
"""Detailed analysis of partial benchmark results from fix_reports/ and output/.

Outputs
-------
CSV (repo root):
  * results_detailed.csv         full per-(model,dataset,direction) breakdown + Wilson CIs
  * results_leaderboard.csv      per-model aggregate (+ CIs + cost-normalised throughput)
  * results_repair_by_type.csv   repair fix-rate split by the original error type
  * results_partial.csv          compact summary (kept for backward compatibility)
  * results_realife_coverage.csv translation coverage for real-life-cli (if any runs exist)

Plots (plots/), each saved as its own file:
  01 pass_rate_attempt1_vs_repair   02 error_breakdown_per_model
  03 heatmap_attempt1               04 heatmap_after_repair
  05 compile_vs_pass                06 failure_composition
  07 repair_effectiveness           08 model_leaderboard (with 95% Wilson CIs)
  09 repair_by_error_type           10 cost_normalized
  11 direction_asymmetry

Outcome model: a translation must compile -> run -> produce correct output.
  compile error  = did not compile / parse
  runtime error  = compiled but crashed
  incorrect      = compiled & ran but wrong output
  "only compiles" (compiled but not passing) = runtime + incorrect

Usage:
  python3 plot_results.py                          # all graded benchmarks
  python3 plot_results.py --datasets codenet avatar
  python3 plot_results.py --models qwen3.5-9b gemma4-e4b
"""

import argparse
import json
import math
from pathlib import Path

import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
import seaborn as sns
import pandas as pd

BASE = Path(__file__).parent.resolve()
FIX_REPORTS = BASE / "fix_reports"
OUTPUT_DIR = BASE / "output"
PLOTS_DIR = BASE / "plots"

# Reuse the mtime-based runtime estimator for cost-normalisation (optional).
try:
    from estimate_runtime import collect as _rt_collect, stats as _rt_stats
    _HAVE_RT = True
except Exception:
    _HAVE_RT = False

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
_KEYS = ["model", "dataset", "src", "tgt"]

# real-life-cli: which source dir maps to which project, and translation direction.
REALIFE_JOBS = [("Python", "Java", "Click"), ("Java", "Python", "Apache Commons CLI")]


# ---------------------------------------------------------------------------
# Stats helpers
# ---------------------------------------------------------------------------

def wilson_ci(k: int, n: int, z: float = 1.96) -> tuple[float, float]:
    """95% Wilson score interval for a proportion, returned as percentages."""
    if not n:
        return (0.0, 0.0)
    p = k / n
    z2 = z * z
    denom = 1 + z2 / n
    center = (p + z2 / (2 * n)) / denom
    half = (z * math.sqrt(p * (1 - p) / n + z2 / (4 * n * n))) / denom
    return (max(0.0, center - half) * 100, min(1.0, center + half) * 100)


def model_active_seconds(label: str) -> float:
    """Estimated GPU-active seconds (translate + repair) for a model, from file mtimes."""
    if not _HAVE_RT:
        return float("nan")
    tot = 0.0
    for d in (OUTPUT_DIR / label, OUTPUT_DIR / f"{label}_IO_1"):
        if d.exists():
            tot += _rt_stats(_rt_collect(d))[2]
    return tot


# ---------------------------------------------------------------------------
# Loading
# ---------------------------------------------------------------------------

def _count_repaired(label: str, dataset: str, src: str, tgt: str) -> int:
    d = OUTPUT_DIR / f"{label}_IO_1" / dataset / src / tgt
    if not d.exists():
        return 0
    ext = _LANG_EXT.get(tgt, "")
    return sum(1 for f in d.iterdir() if f.suffix == ext)


def _repaired_set(label: str, dataset: str, src: str, tgt: str) -> set[str]:
    d = OUTPUT_DIR / f"{label}_IO_1" / dataset / src / tgt
    if not d.exists():
        return set()
    ext = _LANG_EXT.get(tgt, "")
    return {f.name for f in d.iterdir() if f.suffix == ext}


def _parse_attempt1(stem: str):
    left, rest = stem.split("_errors_from_")
    src, tgt = rest.split("_to_")
    sep = left.rfind("_")
    return left[:sep], left[sep + 1:], src, tgt          # model, dataset, src, tgt


def _parse_attempt2(stem: str):
    left, rest = stem.split("_errors_from_")
    src, tgt = rest.split("_to_")
    io_sep = left.index("_IO_1_")
    return left[:io_sep], left[io_sep + len("_IO_1_"):], src, tgt


def load_attempt1() -> pd.DataFrame:
    rows = []
    for f in sorted(FIX_REPORTS.glob("*_errors_*_1.json")):
        model, dataset, src, tgt = _parse_attempt1(f.stem[: f.stem.rfind("_")])
        with open(f) as fp:
            d = json.load(fp)
        compile_e   = len(d.get("compile",   []))
        runtime_e   = len(d.get("runtime",   []))
        incorrect_e = len(d.get("incorrect", []))
        total  = DATASET_SIZES.get((dataset, src, tgt), 0)
        passed = max(0, total - (compile_e + runtime_e + incorrect_e))
        rows.append({
            "model": model, "dataset": dataset, "src": src, "tgt": tgt,
            "direction": f"{src}→{tgt}", "bench": f"{dataset}\n{src}→{tgt}",
            "total": total, "pass": passed, "incorrect": incorrect_e,
            "runtime": runtime_e, "compile": compile_e,
            "pass_rate": passed / total * 100 if total else 0,
        })
    return pd.DataFrame(rows)


def load_attempt2() -> pd.DataFrame:
    """Load retest (post-repair) results. Only rows that have been retested."""
    rows = []
    for f in sorted(FIX_REPORTS.glob("*_IO_1_*_errors_*_2.json")):
        label, dataset, src, tgt = _parse_attempt2(f.stem[: f.stem.rfind("_")])
        with open(f) as fp:
            d = json.load(fp)
        compile_e   = len(d.get("compile",   []))
        runtime_e   = len(d.get("runtime",   []))
        incorrect_e = len(d.get("incorrect", []))
        repaired = _count_repaired(label, dataset, src, tgt)
        repaired_pass = max(0, repaired - (compile_e + runtime_e + incorrect_e))
        rows.append({
            "model": label, "dataset": dataset, "src": src, "tgt": tgt,
            "direction": f"{src}→{tgt}", "bench": f"{dataset}\n{src}→{tgt}",
            "repaired": repaired, "repaired_pass": repaired_pass,
            "rem_compile": compile_e, "rem_runtime": runtime_e, "rem_incorrect": incorrect_e,
        })
    return pd.DataFrame(rows)


def _fname_sets(d: dict) -> dict:
    return {t: {e[0] for e in d.get(t, [])} for t in ("compile", "runtime", "incorrect")}


def load_failure_sets():
    """Return (pre, post): key=(model,dataset,src,tgt) -> per-type filename sets."""
    pre, post = {}, {}
    for f in FIX_REPORTS.glob("*_errors_*_1.json"):
        model, dataset, src, tgt = _parse_attempt1(f.stem[: f.stem.rfind("_")])
        with open(f) as fp:
            pre[(model, dataset, src, tgt)] = _fname_sets(json.load(fp))
    for f in FIX_REPORTS.glob("*_IO_1_*_errors_*_2.json"):
        label, dataset, src, tgt = _parse_attempt2(f.stem[: f.stem.rfind("_")])
        with open(f) as fp:
            post[(label, dataset, src, tgt)] = _fname_sets(json.load(fp))
    return pre, post


# ---------------------------------------------------------------------------
# Derived tables
# ---------------------------------------------------------------------------

def build_detailed_df(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
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

    ci1 = m.apply(lambda r: wilson_ci(r["pass1"], r["total"]), axis=1)
    cif = m.apply(lambda r: wilson_ci(r["final_pass"], r["total"]), axis=1)
    m["pass1_ci_low"]  = [c[0] for c in ci1]
    m["pass1_ci_high"] = [c[1] for c in ci1]
    m["final_ci_low"]  = [c[0] for c in cif]
    m["final_ci_high"] = [c[1] for c in cif]

    cols = [
        "model", "dataset", "direction", "total",
        "pass1", "pass1_rate", "pass1_ci_low", "pass1_ci_high",
        "compile_err1", "runtime_err1", "incorrect_err1",
        "compiled1", "compile_rate1", "compiled_not_pass1", "failed1",
        "repaired", "repaired_pass", "repaired_rate",
        "rem_compile", "rem_runtime", "rem_incorrect",
        "final_pass", "final_rate", "final_ci_low", "final_ci_high", "delta_rate",
    ]
    out = m[cols].copy()
    for c in ["pass1_rate", "pass1_ci_low", "pass1_ci_high", "compile_rate1",
              "repaired_rate", "final_rate", "final_ci_low", "final_ci_high", "delta_rate"]:
        out[c] = out[c].round(2)
    return out.sort_values(["model", "dataset", "direction"]).reset_index(drop=True)


def build_leaderboard_df(det: pd.DataFrame) -> pd.DataFrame:
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

    ci1 = g.apply(lambda r: wilson_ci(r["pass1"], r["snippets"]), axis=1)
    cif = g.apply(lambda r: wilson_ci(r["final_pass"], r["snippets"]), axis=1)
    g["pass1_ci_low"]  = [round(c[0], 2) for c in ci1]
    g["pass1_ci_high"] = [round(c[1], 2) for c in ci1]
    g["final_ci_low"]  = [round(c[0], 2) for c in cif]
    g["final_ci_high"] = [round(c[1], 2) for c in cif]

    g["active_sec"]   = g["model"].apply(model_active_seconds)
    g["active_hours"] = (g["active_sec"] / 3600).round(2)
    g["passed_per_hour"] = (g["final_pass"] / (g["active_sec"] / 3600)).round(1)

    cols = ["model", "benchmarks", "snippets", "pass1", "final_pass",
            "pass1_rate", "pass1_ci_low", "pass1_ci_high", "compile_rate",
            "repaired", "repaired_pass", "repaired_rate",
            "final_rate", "final_ci_low", "final_ci_high", "repair_gain",
            "active_hours", "passed_per_hour"]
    return g[cols].sort_values("final_rate", ascending=False).reset_index(drop=True)


def build_repair_by_type_df(pre: dict, post: dict) -> pd.DataFrame:
    """For each original error type, how many failures were repaired and actually fixed."""
    rows = []
    for key, pre_sets in pre.items():
        model, dataset, src, tgt = key
        if key not in post:
            continue                                   # not retested -> skip
        repaired = _repaired_set(model, dataset, src, tgt)
        if not repaired:
            continue
        still_all = set().union(*post[key].values())
        for t in ("compile", "runtime", "incorrect"):
            attempted = pre_sets[t] & repaired
            fixed = attempted - still_all
            rows.append({
                "model": model, "dataset": dataset, "direction": f"{src}→{tgt}",
                "error_type": t, "pre": len(pre_sets[t]),
                "attempted": len(attempted), "fixed": len(fixed),
                "fix_rate": round(len(fixed) / len(attempted) * 100, 2) if attempted else float("nan"),
            })
    return pd.DataFrame(rows)


def build_summary_df(det: pd.DataFrame) -> pd.DataFrame:
    return det[["model", "dataset", "direction", "total", "pass1", "pass1_rate",
                "repaired", "repaired_pass", "repaired_rate",
                "final_pass", "final_rate"]].copy()


def realife_coverage_df() -> pd.DataFrame:
    base = BASE / "dataset" / "real-life-cli"
    if not base.exists():
        return pd.DataFrame()
    labels = sorted(
        d.name for d in OUTPUT_DIR.iterdir()
        if d.is_dir() and not d.name.endswith("_IO_1") and (d / "real-life-cli").exists()
    )
    rows = []
    for label in labels:
        for src, tgt, project in REALIFE_JOBS:
            sdir = base / src / "Code"
            total = sum(1 for f in sdir.iterdir() if f.is_file()) if sdir.exists() else 0
            odir = OUTPUT_DIR / label / "real-life-cli" / src / tgt
            done = (sum(1 for f in odir.iterdir() if f.is_file() and f.stat().st_size > 0)
                    if odir.exists() else 0)
            rows.append({"model": label, "project": project,
                         "direction": f"{src}→{tgt}", "translated": done, "total": total})
    return pd.DataFrame(rows)


# ---------------------------------------------------------------------------
# Console table
# ---------------------------------------------------------------------------

def print_table(det: pd.DataFrame) -> None:
    header = (f"{'Model':<16} {'Dataset':<9} {'Direction':<13} "
              f"{'Tot':>4} {'Pass1':>5} {'Rate1':>6} {'Cmpl%':>6} {'OnlyC':>5}  "
              f"{'Rep':>4} {'RepP':>5} {'Final':>5} {'FinalR':>7} {'Δpp':>6}")
    print(header)
    print("-" * len(header))
    for _, r in det.iterrows():
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
    models = sorted(det["model"].unique())
    fig, axes = plt.subplots(1, len(models), figsize=(5 * len(models), 6),
                             squeeze=False, sharey=True)
    axes = axes[0]
    for ax, model in zip(axes, models):
        sub = det[det["model"] == model].copy()
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
    y = list(range(len(lb)))
    fig, ax = plt.subplots(figsize=(11, 0.8 * len(lb) + 2))
    ax.barh([yi + 0.22 for yi in y], lb["compile_rate"], height=0.2,
            color="#90caf9", label="compile rate")
    p1_err = [lb["pass1_rate"] - lb["pass1_ci_low"], lb["pass1_ci_high"] - lb["pass1_rate"]]
    ax.barh(y, lb["pass1_rate"], height=0.2, color="#1565c0", label="pass@1",
            xerr=p1_err, error_kw={"ecolor": "#0d2f5c", "elinewidth": 1, "capsize": 3})
    fn_err = [lb["final_rate"] - lb["final_ci_low"], lb["final_ci_high"] - lb["final_rate"]]
    ax.barh([yi - 0.22 for yi in y], lb["final_rate"], height=0.2, color="#4caf50",
            label="final (after repair)", xerr=fn_err,
            error_kw={"ecolor": "#1b5e20", "elinewidth": 1, "capsize": 3})
    ax.set_yticks(y)
    ax.set_yticklabels(lb["model"])
    ax.set_xlabel("Rate (%) — snippet-weighted across all benchmarks (error bars = 95% Wilson CI)")
    ax.set_xlim(0, 105)
    ax.set_title("Model leaderboard", fontweight="bold", fontsize=14)
    ax.legend(loc="lower right", fontsize=9)
    ax.grid(axis="x", alpha=0.3)
    for yi, (_, r) in zip(y, lb.iterrows()):
        ax.text(min(r["final_ci_high"] + 1.5, 101), yi - 0.22, f"{r['final_rate']:.0f}%",
                va="center", fontsize=8)
    _save(fig, "08_model_leaderboard.png")


# 09 -------------------------------------------------------------------------
def fig_repair_by_error_type(rt: pd.DataFrame) -> None:
    if rt.empty:
        return
    agg = rt.groupby(["model", "error_type"], as_index=False).agg(
        attempted=("attempted", "sum"), fixed=("fixed", "sum"))
    agg["fix_rate"] = agg["fixed"] / agg["attempted"].where(agg["attempted"] > 0) * 100
    pivot = agg.pivot(index="model", columns="error_type", values="fix_rate")
    order = [t for t in ("compile", "runtime", "incorrect") if t in pivot.columns]
    pivot = pivot[order]

    models = pivot.index.tolist()
    x = range(len(models))
    width = 0.25
    fig, ax = plt.subplots(figsize=(2 + 1.6 * len(models), 6))
    for i, t in enumerate(order):
        offset = (i - len(order) / 2 + 0.5) * width
        bars = ax.bar([xi + offset for xi in x], pivot[t], width=width,
                      color=ERROR_COLORS[t], edgecolor="white", label=t)
        ax.bar_label(bars, fmt="%.0f", fontsize=8, padding=2)
    ax.set_xticks(list(x))
    ax.set_xticklabels(models, rotation=15, ha="right")
    ax.set_ylabel("Fix rate (%) of repaired files")
    ax.set_ylim(0, 105)
    ax.set_title("Repair fix-rate by original error type",
                 fontweight="bold", fontsize=14)
    ax.legend(title="Original error", fontsize=9)
    ax.grid(axis="y", alpha=0.3)
    _save(fig, "09_repair_by_error_type.png")


# 10 -------------------------------------------------------------------------
def fig_cost_normalized(lb: pd.DataFrame) -> None:
    if lb["active_hours"].isna().all():
        print("Skipping cost plot (runtime estimate unavailable).")
        return
    d = lb.dropna(subset=["active_hours"]).copy()
    fig, (axA, axB) = plt.subplots(1, 2, figsize=(16, 6))

    axA.scatter(d["active_hours"], d["final_rate"], s=140, color="#1565c0", zorder=3)
    for _, r in d.iterrows():
        axA.annotate(r["model"], (r["active_hours"], r["final_rate"]),
                     textcoords="offset points", xytext=(6, 4), fontsize=9)
    axA.set_xlabel("GPU active hours (translate + repair, mtime-estimated)")
    axA.set_ylabel("Final pass rate (%)")
    axA.set_title("Quality vs Cost", fontweight="bold", fontsize=13)
    axA.grid(alpha=0.3)

    d2 = d.sort_values("passed_per_hour")
    axB.barh(d2["model"], d2["passed_per_hour"], color="#4caf50", edgecolor="white")
    for i, v in enumerate(d2["passed_per_hour"]):
        axB.text(v + 0.5, i, f"{v:.0f}", va="center", fontsize=9)
    axB.set_xlabel("Snippets passed per GPU-hour (final)")
    axB.set_title("Throughput — useful output per GPU-hour", fontweight="bold", fontsize=13)
    axB.grid(axis="x", alpha=0.3)

    fig.suptitle("Cost-normalised quality", fontweight="bold", fontsize=15)
    _save(fig, "10_cost_normalized.png")


# 11 -------------------------------------------------------------------------
def fig_direction_asymmetry(det: pd.DataFrame) -> None:
    bi = det[det["dataset"].isin(["codenet", "avatar"])]   # datasets with both directions
    if bi.empty:
        return
    g = bi.groupby(["model", "direction"], as_index=False).agg(
        pass1=("pass1", "sum"), total=("total", "sum"))
    g["pass1_rate"] = g["pass1"] / g["total"] * 100
    pivot = g.pivot(index="model", columns="direction", values="pass1_rate")
    dirs = [d for d in ("Java→Python", "Python→Java") if d in pivot.columns]
    pivot = pivot[dirs]

    models = pivot.index.tolist()
    x = range(len(models))
    width = 0.38
    colors = {"Java→Python": "#26a69a", "Python→Java": "#ab47bc"}
    fig, ax = plt.subplots(figsize=(2 + 1.7 * len(models), 6))
    for i, d in enumerate(dirs):
        offset = (i - len(dirs) / 2 + 0.5) * width
        bars = ax.bar([xi + offset for xi in x], pivot[d], width=width,
                      color=colors.get(d, None), edgecolor="white", label=d)
        ax.bar_label(bars, fmt="%.0f", fontsize=8, padding=2)
    ax.set_xticks(list(x))
    ax.set_xticklabels(models, rotation=15, ha="right")
    ax.set_ylabel("Pass@1 (%) — codenet + avatar, snippet-weighted")
    ax.set_ylim(0, 105)
    ax.set_title("Translation direction asymmetry (Java→Python vs Python→Java)",
                 fontweight="bold", fontsize=14)
    ax.legend(fontsize=9)
    ax.grid(axis="y", alpha=0.3)
    _save(fig, "11_direction_asymmetry.png")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def main() -> None:
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--datasets", nargs="+", help="filter to these datasets")
    ap.add_argument("--models", nargs="+", help="filter to these model labels")
    args = ap.parse_args()

    sns.set_theme(style="whitegrid", font_scale=0.95)
    df1 = load_attempt1()
    df2 = load_attempt2()
    pre, post = load_failure_sets()

    if args.datasets:
        ds = set(args.datasets)
        df1 = df1[df1["dataset"].isin(ds)]
        df2 = df2[df2["dataset"].isin(ds)] if not df2.empty else df2
        pre = {k: v for k, v in pre.items() if k[1] in ds}
        post = {k: v for k, v in post.items() if k[1] in ds}
    if args.models:
        ms = set(args.models)
        df1 = df1[df1["model"].isin(ms)]
        df2 = df2[df2["model"].isin(ms)] if not df2.empty else df2
        pre = {k: v for k, v in pre.items() if k[0] in ms}
        post = {k: v for k, v in post.items() if k[0] in ms}

    if df1.empty:
        print("No matching error JSON files in fix_reports/. "
              "(Graded datasets only — real-life-cli is evaluated manually.)")
    else:
        detailed    = build_detailed_df(df1, df2)
        leaderboard = build_leaderboard_df(detailed)
        repair_type = build_repair_by_type_df(pre, post)

        print_table(detailed)
        print("Leaderboard (snippet-weighted across benchmarks):")
        print(leaderboard.to_string(index=False))
        print()
        if not repair_type.empty:
            agg = repair_type.groupby(["model", "error_type"], as_index=False).agg(
                attempted=("attempted", "sum"), fixed=("fixed", "sum"))
            agg["fix_rate%"] = (agg["fixed"] / agg["attempted"].where(agg["attempted"] > 0)
                                * 100).round(1)
            print("Repair fix-rate by original error type:")
            print(agg.to_string(index=False))
            print()

        detailed.to_csv(BASE / "results_detailed.csv", index=False)
        leaderboard.to_csv(BASE / "results_leaderboard.csv", index=False)
        repair_type.to_csv(BASE / "results_repair_by_type.csv", index=False)
        build_summary_df(detailed).to_csv(BASE / "results_partial.csv", index=False)
        for name in ("results_detailed", "results_leaderboard",
                     "results_repair_by_type", "results_partial"):
            print(f"Saved → {BASE / (name + '.csv')}")
        print()

        fig_pass_rate(df1, df2)
        fig_error_breakdown(df1)
        fig_heatmaps(df1, df2)
        fig_compile_vs_pass(detailed)
        fig_failure_composition(detailed)
        if not df2.empty:
            fig_repair_effectiveness(detailed)
        fig_leaderboard(leaderboard)
        fig_repair_by_error_type(repair_type)
        fig_cost_normalized(leaderboard)
        fig_direction_asymmetry(detailed)

    # real-life-cli: no test cases -> report translation coverage only.
    if not args.datasets or "real-life-cli" in args.datasets:
        cov = realife_coverage_df()
        if not cov.empty and cov["translated"].sum() > 0:
            print("real-life-cli translation coverage (no auto-grading; manual eval):")
            print(cov.to_string(index=False))
            cov.to_csv(BASE / "results_realife_coverage.csv", index=False)
            print(f"Saved → {BASE / 'results_realife_coverage.csv'}")


if __name__ == "__main__":
    main()
