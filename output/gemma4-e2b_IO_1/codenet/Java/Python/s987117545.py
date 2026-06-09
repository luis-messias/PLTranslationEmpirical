import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        n = int(data[0])
        k = int(data[1])
    except ValueError:
        # Handle case where conversion fails
        return

    DEVISOR = 1000000000 + 7
    ans = 0
    
    # Loop from k to n+1 (inclusive)
    # Java: for (long i = k; i <= n+1; i++)
    for i in range(k, n + 2):
        # Calculate max and min using integer division //
        # max = i * (2*n - i + 1) / 2
        max_val
