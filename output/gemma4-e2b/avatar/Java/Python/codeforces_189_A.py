import sys

def solve():
    # Read all inputs from stdin
    try:
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        
        n = int(data[0])
        a = int(data[1])
        b = int(data[2])
        c = int(data[3])
    except:
        # Handle potential reading errors if input format is unexpected
        return

    maxn = 4010
    arr = [a, b, c]
    
    # Initialize DP array. Use a value representing negative infinity for