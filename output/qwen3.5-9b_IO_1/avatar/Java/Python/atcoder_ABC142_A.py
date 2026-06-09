import sys

try:
    input_val = float(sys.stdin.readline())
    count_odd = round(input_val / 2)
    result = count_odd / input_val
    print(f"{result:.10f}")
except Exception:
    sys.exit(0)
