import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    idx = 0
    
    N = int(data[idx])
    idx += 1
    X = int(data[idx])
    idx += 1
    
    x = [int(data[idx + i]) for i in range(N)]
    idx += N
    
    xsum = [0] * (N + 1)
    for i in range(N):
        xsum[i + 1] = xsum[i] + x[i]
    
    ans = X * N + 5 * xsum[N]
    
    for i in range(1, N):
        cost = X * i + 5 * (xsum[N] - xsum[N - i])
        j = 5
        k = N - i
        while k >= 0:
            if cost > ans:
                break
            cost += j * (xsum[k] - xsum[max(k - i, 0)])
            j += 2
            k -= i
        ans = min(ans, cost)
    
    print(ans + N * X)

if __name__ == "__main__":
    solve()