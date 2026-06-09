import sys

try:
    # Read the short integer from standard input
    r = int(sys.stdin.read().strip())
except:
    # Handle case where input might be missing or invalid, though typically not needed for direct translation context
    # If running interactively, we might use input() instead. Assuming standard input reading for robustness.
    pass

if r < 1200:
    print("ABC")
elif r < 2800:
    print("ARC")
else:
    print("AGC")