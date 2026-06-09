import sys

n = int(input())
arr = [list(input()) for _ in range(n)]
a, b = arr[0][0], arr[0][1]

if a == b:
    print("NO")
else:
    res = True
    for i in range(n):
        for j in range(n):
            if i == j or i + j == n - 1:
                if arr[i][j] != a:
                    res = False
                    break
            else:
                if arr[i][j] != b:
                    res = False
                    break
    print("YES" if res else "NO")