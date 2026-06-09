MOD = 10**9 + 7

def solve():
    xx = list(map(int, input().split()))
    min_val = min(xx[0], xx[1])
    max_val = max(xx[0], xx[1])

    if min_val == max_val:
        res = (2 * f(min_val) ** 2) % MOD
    elif min_val + 1 == max_val:
        res = (f(min_val) * ((f(max_val) % MOD))) % MOD
    else:
        res = 0

    print(res)

def f(n):
    res = 1
    for i in range(2, n+1):
        res = (res * i) % MOD
    return res

def main():
    try:
        solve()
    except Exception as e:
        print(e)

if __name__ == "__main__":
    main()