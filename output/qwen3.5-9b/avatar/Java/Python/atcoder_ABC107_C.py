import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    K = int(next(iterator))
    S = [int(next(iterator)) for _ in range(N)]
    
    ans = 1000000000
    
    if K == 1:
        for i in range(N):
            ans = min(ans, abs(S[i]))
        print(ans)
    elif N - K != 0:
        for i in range(N - K + 1):
            min_val = S[i]
            max_val = S[i + K - 1]
            if min_val < 0 and max_val > 0:
                temp = min(2 * (-min_val) + max_val, (-min_val) + 2 * max_val)
            else:
                temp = max(abs(min_val), abs(max_val))
            ans = min(ans, temp)
        print(ans)
    else:
        min_val = S[0]
        max_val = S[N - 1]
        if min_val < 0 and max_val > 0:
            print(min(2 * (-min_val) + max_val, (-min_val) + 2 * max_val))
        else:
            print(max(abs(min_val), abs(max_val)))

if __name__ == "__main__":
    main()