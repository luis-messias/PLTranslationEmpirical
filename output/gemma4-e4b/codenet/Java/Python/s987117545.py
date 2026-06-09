import sys

def solve():
    # Read all input from stdin and split it
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        n = int(data[0])
        k = int(data[1])
    except Exception:
        # Handle case where input might be missing
        return

    DEVISOR = 1000000000 + 7
    
    ans = 0
    
    # Loop from k to n + 1 (inclusive). Python range stops before the second argument.
    for i in range(k, n + 2):
        # max = i * (2*n - i + 1) / 2
        # Use integer division //
        max_val = i * (2 * n - i + 1) // 2
        
        # min = i * (i - 1) / 2
        min_val = i * (i - 1) // 2
        
        # Calculate the term: (max - min + 1)
        term = max_val - min_val + 1
        
        # Add to ans, applying modulo at each step
        ans = (ans + term) % DEVISOR
        
    print(ans)

if __name__ == "__main__":
    solve()