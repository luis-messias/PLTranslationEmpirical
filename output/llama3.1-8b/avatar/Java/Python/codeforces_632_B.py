import sys

def main():
    n = int(input())
    a = list(map(int, input().split()))
    s = input()
    sum_ = 0
    for i in range(n):
        if s[i] == 'B':
            sum_ += a[i]
    ans = sum_
    sum1 = sum_
    for i in range(n):
        if s[i] == 'A':
            sum1 += a[i]
        else:
            sum1 -= a[i]
        ans = max(ans, sum1)
    sum1 = sum_
    for i in range(n-1, -1, -1):
        if s[i] == 'A':
            sum1 += a[i]
        else:
            sum1 -= a[i]
        ans = max(ans, sum1)
    print(ans)

if __name__ == "__main__":
    main()