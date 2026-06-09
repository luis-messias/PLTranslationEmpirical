import sys

def main():
    n, m, x = map(int, input().split())
    a = [[0] * (m + 1) for _ in range(n)]
    for i in range(n):
        a[i] = list(map(int, input().split()))

    min_val = float('inf')
    for i in range(2 ** n):
        status = [0] * n
        for j in range(n):
            if (i >> j) & 1:
                status[j] = 1

        res = [0] * (m + 1)
        for j in range(n):
            if status[j]:
                for k in range(m + 1):
                    res[k] += a[j][k]

        flag = True
        for j in range(1, m + 1):
            if res[j] < x:
                flag = False
                break

        if flag:
            min_val = min(min_val, res[0])

    if min_val == float('inf'):
        print(-1)
    else:
        print(min_val)

if __name__ == "__main__":
    main()