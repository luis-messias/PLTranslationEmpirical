import sys

def main():
    n = int(input())
    a = []
    for i in range(n):
        line = input().split()
        a.append([int(x) for x in line])
    m = 0
    for i in range(1, n):
        if abs(a[m][0]) < abs(a[i][0]):
            m = i
    r = []
    for i in range(n):
        if (a[m][0] >= 0) ^ (a[i][0] >= 0):
            r.append(f"{m + 1} {i + 1}")
    if a[m][0] >= 0:
        for i in range(1, n):
            r.append(f"{i} {i + 1}")
    else:
        for i in range(n - 1, 0, -1):
            r.append(f"{i} {i - 1}")
    print(len(r))
    for s in r:
        print(s)

if __name__ == "__main__":
    main()
