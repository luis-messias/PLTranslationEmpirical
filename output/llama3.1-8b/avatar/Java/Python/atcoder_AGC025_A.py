import math
def sum_digits(n):
    ans = 0
    while n >= 10:
        ans += n % 10
        n //= 10
    ans += n
    return ans

N = int(input())
n = N // 2 if N % 2 == 0 else (N + 1) // 2
ans = sum_digits(1) + sum_digits(N - 1)
for A in range(1, n + 1):
    if sum_digits(A) + sum_digits(N - A) < ans:
        ans = sum_digits(A) + sum_digits(N - A)
print(ans)