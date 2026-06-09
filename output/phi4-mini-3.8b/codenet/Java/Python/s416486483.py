import math

def split(n, k):
    sum_ = 0
    while n > 0:
        sum_ += n % k
        n //= k
    return sum_

def solve(n, s):
    for k in range(2, int(math.sqrt(n)) + 1 or 100):
        if split(n, k) == s:
            return k

    while True:
        a = n // (k := max(k - 1, 0))
        b = n % (k := math.ceil((n - s) / a))

        if ((a + b - s) % a == 0 and
                0 <= dk := int(math.floor(b - s) / a)):
            return k + dk

        k += 1
        if not k:
            break
    
    if n == s:
        return (n + 1)
    
    return (-1)

if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = list(map(int, input().split())
    print(solve(data[0], data[1]))