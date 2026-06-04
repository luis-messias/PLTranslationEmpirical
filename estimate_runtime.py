#!/usr/bin/env python3
"""Estimate per-model execution time from output file modification times.

No rerun needed — we infer how long each model took to generate its translations
(and repairs) from the mtimes of the files it produced.

Two estimates per model:
  * span    = last_mtime - first_mtime          (includes idle gaps between sessions)
  * active  = sum of consecutive gaps <= GAP    (drops idle gaps -> ~real compute time)

GAP is the idle threshold: a gap between two consecutive file writes larger than
GAP is treated as "process not running" and excluded from the active total.
"""

import sys
from pathlib import Path
from collections import defaultdict

BASE = Path(__file__).parent.resolve()
OUTPUT = BASE / "output"
GAP = 120.0  # seconds; gaps larger than this are treated as idle (excluded from active)

# Only count generated source translations, not build/test artifacts (.pyc, .class, ...).
# These are the files the model actually wrote during translate/repair.
SOURCE_EXTS = {".java", ".py", ".c", ".cpp", ".go"}


def fmt(seconds: float) -> str:
    h, rem = divmod(int(seconds), 3600)
    m, s = divmod(rem, 60)
    if h:
        return f"{h}h{m:02d}m{s:02d}s"
    if m:
        return f"{m}m{s:02d}s"
    return f"{s}s"


def collect(label_dir: Path):
    """Return sorted mtimes of generated source files (excludes .pyc/.class artifacts)."""
    return sorted(f.stat().st_mtime for f in label_dir.rglob("*")
                  if f.is_file() and f.suffix in SOURCE_EXTS)


def stats(mtimes):
    n = len(mtimes)
    if n < 2:
        return n, 0.0, 0.0
    span = mtimes[-1] - mtimes[0]
    active = 0.0
    for a, b in zip(mtimes, mtimes[1:]):
        d = b - a
        if d <= GAP:
            active += d
    return n, span, active


def main():
    # group output dirs by model: "<label>" (translate) and "<label>_IO_1" (repair)
    models = defaultdict(dict)  # model -> {"translate": dir, "repair": dir}
    for d in sorted(OUTPUT.iterdir()):
        if not d.is_dir():
            continue
        if d.name.endswith("_IO_1"):
            models[d.name[: -len("_IO_1")]]["repair"] = d
        else:
            models[d.name]["translate"] = d

    header = (f"{'Model':<18} {'Stage':<10} {'Files':>6} "
              f"{'Span':>12} {'Active':>10} {'Avg/file':>9}")
    print(header)
    print("-" * len(header))

    grand = defaultdict(lambda: [0, 0.0])  # model -> [files, active]
    for model in sorted(models):
        for stage in ("translate", "repair"):
            d = models[model].get(stage)
            if d is None:
                continue
            n, span, active = stats(collect(d))
            avg = active / n if n else 0
            print(f"{model:<18} {stage:<10} {n:>6} "
                  f"{fmt(span):>12} {fmt(active):>10} {avg:>8.1f}s")
            grand[model][0] += n
            grand[model][1] += active
        gn, ga = grand[model]
        print(f"{model:<18} {'TOTAL':<10} {gn:>6} {'':>12} {fmt(ga):>10} "
              f"{ga/gn if gn else 0:>8.1f}s")
        print()

    print("=" * len(header))
    tot_files = sum(v[0] for v in grand.values())
    tot_active = sum(v[1] for v in grand.values())
    print(f"{'ALL MODELS':<18} {'':<10} {tot_files:>6} {'':>12} {fmt(tot_active):>10}")
    print(f"\n(idle-gap threshold = {GAP:.0f}s; 'active' excludes longer gaps. "
          f"Pass a different threshold: {sys.argv[0]} <seconds>)")


if __name__ == "__main__":
    if len(sys.argv) > 1:
        GAP = float(sys.argv[1])
    main()
