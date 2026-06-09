import sys

def solve():
    # Read input n
    try:
        # Read the single integer n from standard input
        n = int(sys.stdin.read().strip())
    except:
        # Handle case where input might be empty
        return

    ans = 0
    # The loop runs for i from 1 to n (inclusive)
    for i in range(1, n + 1):
        # Calculate k = floor(n / i)
        k = n // i
        
        # Calculate the term: i * k * (k + 1) / 2
        # This corresponds to the Java expression: i * (n/i) * ((n/i) + 1) / 2
        # We use integer division // for the final division.
        term = i * k * (k + 1) // 2
        ans += term
        
    print(ans)

solve()