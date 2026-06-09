import sys
from typing import List

def main():
    x = [int(input()) for _ in range(3)]
    max_val = max(x)
    k = int(input())

    a = [[0] * (x[i] + 1) for i in range(3)]

    for i in range(3):
        for j in range(x[i]):
            a[i][j+1] = int(input())
        a[i].sort()

    ans = []
    for i in range(x[0]):
        for j in range(x[1]):
            for m in range(x[2]):
                if (i + 1) * (j + 1) * (m + 1) <= k:
                    tmp = sum(a[i][x[0] - i - 1:j+1]) + sum(a[j][x[1] - j - 1:m+1])
                    ans.append(tmp)

    ans.sort(reverse=True)
    for i in range(k):
        print(ans[i])

if __name__ == "__main__":
    main()