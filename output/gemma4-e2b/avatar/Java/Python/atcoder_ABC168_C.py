import math
import sys

def solve():
    # Read A, B, H, M from standard input
    try:
        # Read all inputs from a single line or sequential lines
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        A = int(data[0])
        B = int(data[1])
        H = int(data[2])
        M = int(data[3])
    except Exception:
        # Handle potential reading errors if input format is unexpected
        return

    # Calculations based on the Java logic:
    # AA = A, BB = B, HH = H, MM = M (using float representation)

    # mkaku = MM * 6
    mkaku = M * 6.0

    # hkaku = HH * 30 + M / 2
    # Note: M/2 in Java results in a double