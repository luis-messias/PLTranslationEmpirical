import sys

def solve():
    # Read n from standard input
    try:
        # Read all input and strip whitespace, then convert to int
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except Exception:
        # Handle case where input might be missing or malformed
        return

    ans = 0
    
    # Loop i from 1 to n (inclusive)
    for i in range(1, n + 1):
        # Calculate k = floor(n / i) using integer division
        k = n // i
        
        # Calculate the term: i * k * (k + 1) / 2
        # We use integer division // throughout to maintain integer arithmetic
        term = i * k * (k + 1) // 2
        
        ans += term
        
    print(ans)

solve()