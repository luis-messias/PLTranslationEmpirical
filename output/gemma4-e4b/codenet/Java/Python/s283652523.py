import sys

def solve():
    # Read all input numbers from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    try:
        N = int(input_data[0])
    except ValueError:
        return

    # A is the array of N integers
    if len(input_data) < N + 1:
        # Handle case where input might be incomplete
        return
        
    A = [int(x) for x in input_data[1:N+1]]
    
    MOD = 10**9 + 7
    
    if N == 0:
        print(0)
        return

    # Initialization
    ans = 0
    # sum starts with A[N-1]
    sum_val = A[N-1] % MOD
    
    # Iterate from N-2 down to 0
    for i in range(N - 2, -1, -1):
        # 1. Calculate term: (sum * A[i]) % MOD
        term = (sum_val * A[i]) % MOD
        
        # 2. Update ans: ans = (ans + term) % MOD
        ans = (ans + term) % MOD
        
        # 3. Update sum: sum = (sum + A[i]) % MOD
        sum_val = (sum_val + A[i]) % MOD
        
    print(ans)

if __name__ == "__main__":
    solve()