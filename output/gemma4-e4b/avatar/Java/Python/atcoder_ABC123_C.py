import math
import sys

def solve():
    # Read all input tokens from stdin
    try:
        data = [int(x) for x in sys.stdin.read().split()]
    except:
        return

    if len(data) < 6:
        return

    N = data[0]
    
    # The 5 numbers used to determine min are data[1] through data[5]
    min_candidates = data[1:6]
    
    if not min_candidates:
        return

    min_val = min(min_candidates)
    
    # Calculate ceil(N / min) + 4
    # Ensure floating point division for N / min_val
    result = math.ceil(N / min_val) + 4
    
    # Print the integer result
    print(int(result))

if __name__ == "__main__":
    solve()