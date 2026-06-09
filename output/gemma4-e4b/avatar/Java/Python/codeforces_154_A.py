import sys

def solve():
    # Read all lines from standard input
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # Line 1: arr (the sequence of characters)
    arr = input_data[0]
    N = len(arr)
    
    # Line 2: K (number of test cases)
    try:
        K = int(input_data[1])
    except (IndexError, ValueError):
        return

    # Lines 3 onwards: input strings
    input_lines = input_data[2:2+K]
    
    res = 0
    
    for input_str