import sys

def solve():
    # Read all lines from standard input
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # Line 1: a and tA
    line1 = input_data[0].split()
    a = int(line1[0])
    tA = int(line1[1])

    # Line 2: b and tB
    line2 = input_data[1].split()
    b = int(line2[0])
    tB = int(line2[1])

    # Line 3: timing (HHMM)
    timing = input_data[2].strip()
    
    # Parse time (Assuming standard