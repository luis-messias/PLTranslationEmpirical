import sys
class atcoder_AGC027_B:
    INF = sys.maxsize
    def solve(self):
        N, X = map(int, input().split())
        x = list(map(int, input().split()))
        xsum = [0] * (N + 1)
        for i in range(N):
            xsum[i+1] = xsum[i] + x[i]
        ans = X * N + 5 * sum(x)

        for i in range(1, N):
            cost = X * i + 5 * (sum(x[:N-i]) - sum(x[:i]))
            j, k = 5, N - i
            while k >= 0:
                if cost > ans:
                    break
                cost += j * (xsum[k] - xsum[max(k - i, 0)])
                j += 2
                k -= i
            ans = min(ans, cost)

        print(ans + N * X)
atcoder_AGC027_B().solve()
