import sys

def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split())) + [0]
    cnt = [0] * (n + 1)
    cnt[0] = 1
    MOD = 1000000007

    for i in range(1, m + 1):
        if a[i] == 1:
            cnt[1] = 0
            break
        else:
            cnt[1] = 1

    for i in range(2, n + 1):
        cnt[i] = (cnt[i - 2] + cnt[i - 1]) % MOD
        if a[i] == i:
            cnt[i] = 0

    print(cnt[n])

if __name__ == "__main__":
    main()