import sys

class atcoder_AGC027_B:
    INF = sys.maxsize

    def solve(self):
        sc = input()
        N, X = map(int, sc.split())
        x = [int(i) for i in input().split()]
        xsum = [0] * (N + 1)
        for i in range(N):
            x[i] = int(x[i])
            xsum[i+1] = xsum[i] + x[i]

        ans = X * N + 5 * sum(x)

        for i in range(1, N):
            cost = X * i + 5 * (sum(x) - sum(x[:N-i]))
            j, k = 5, N - i
            while j <= 10 and k >= 0:
                if cost > ans:
                    break
                cost += j * (xsum[k] - xsum[max(k - i, 0)])
                j += 2
                k -= i
            ans = min(ans, cost)

        print(ans + N * X)

atcoder_AGC027_B().solve()