import sys

N, K, Q, A, B, C = 0, 0, 0, 0, 0, 0
min_val = 9999999
ans = 0

def main():
    global N, ans
    scanner = sys.stdin.readline
    N = int(scanner())

    s = scanner().strip()

    flag = False
    ans = 0
    hen = 0
    sha = 0
    dot = 0
    temp = 0
    first = True

    for i in range(N):
        if(s[i] == '#'):
            first = False
            if(sha <= dot):
                ans += sha
                sha = 0
                dot = 0
                first = True
            else:
                pass

            sha += 1
        else:
            dot += 1

    if(sha <= dot):
        ans += sha
        dot = 0

    print(ans + dot)

if __name__ == "__main__":
    main()