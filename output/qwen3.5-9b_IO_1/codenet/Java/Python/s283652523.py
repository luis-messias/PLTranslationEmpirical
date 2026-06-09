import sys

MOD = 10**9 + 7

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    N = int(next(iterator))
    A = [int(next(iterator)) for _ in range(N)]
    
    ans = 0
    sum_val = A[N-1]
    for i in range(N - 2, -1, -1):
        ans = (ans + sum_val * A[i]) % MOD
        sum_val = (sum_val + A[i]) % MOD
    
    print(ans)

if __name__ == "__main__":
    solve()
