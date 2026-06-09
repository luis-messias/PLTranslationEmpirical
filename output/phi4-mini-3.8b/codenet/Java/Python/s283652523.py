import sys

MOD = int(1e9 + 7)

def main():
    input_stream = iter(sys.stdin.read().strip())
    
    def next_int():
        while True:
            try:
                value = int(next(input_stream))
                return value
            except ValueError as e:
                continue
    
    N = next_int()
    A = [next_int() for _ in range(N)]
    
    ans, sum_ = 0, A[-1]
    for i in reversed(range(N - 1)):
        ans += (sum_ * A[i]) % MOD
        ans %= MOD
        sum_ += A[i]
        sum_ %= MOD
    
    print(ans)

if __name__ == "__main__":
    main()