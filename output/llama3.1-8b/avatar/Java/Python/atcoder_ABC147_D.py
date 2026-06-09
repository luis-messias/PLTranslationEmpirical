import sys, math

def main():
    n = int(input())
    div = 10**9 + 7
    A = [int(x) for x in input().split()]
    
    ans = 0
    for i in range(60):
        count1 = sum((A[j] >> i) & 1 == 1 for j in range(n))
        a = count1 * (n - count1)
        for _ in range(i):
            a = (a << 1) % div
        ans += a
        ans %= div
    
    print(ans)

if __name__ == "__main__":
    main()