import sys
from functools import reduce

def main():
    S = input()[::-1]

    dp = [0] * 13
    dp[0] = 1

    d = 1
    for i, c in enumerate(S):
        if c.isdigit():
            x = int(c) * d
            nd = [dp[(j + x) % 13] for j in range(13)]
        else:
            nd = reduce(lambda a, b: [(a[i] + b[i]) % 1000000007 for i in range(13)], 
                        [[0] * 13 for _ in range(10)],
                        [0] * 13)
            for xi in range(10):
                x = xi * d
                nd[(j + x) % 13] += dp[j]
        print(nd)
        d = (d * 10) % 13

    print(dp[5])

if __name__ == "__main__":
    main()