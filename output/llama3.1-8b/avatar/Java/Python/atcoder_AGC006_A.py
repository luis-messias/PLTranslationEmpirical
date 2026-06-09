import sys

N = 200 + 10
f = [0] * N
b = [''] * N

def getFail(b, m):
    j = 0
    f[0] = f[1] = 0
    for i in range(2, m+1):
        while j > 0 and b[j+1] != b[i]:
            j = f[j]
        if b[j+1] == b[i]:
            j += 1
        f[i] = j

def main():
    n = int(input())
    s1 = input()
    str = input()
    cnt = 0
    for i in range(n):
        b[cnt] = str[i]
        cnt += 1
    for i in range(n):
        b[cnt] = s1[i]
        cnt += 1
    getFail(b, cnt)
    len_ = min(f[cnt], n)
    print(2 * n - len_)
    sys.stdout.flush()

if __name__ == "__main__":
    main()