import math

def next():
    try:
        while True: 
            yield sc.next()
    except StopIteration as e:
        return str(e.value)

sc = iter(input().split())

n, a, b = map(int, [next(), next(), next()])

sa = abs(a - b)
ans = 0

if sa % 2 == 0:
    ans = sa // 2
else:
    AAA = min(n - a, a - 1)
    BBB = min(n - b, b - 1)

    ans = min(AAA, BBB) # one side reaches the edge.

    # Decrease difference by 1 to make it even.
    sa -= 1
    ans += 1

    # Difference is now even.
    ans += sa // 2

print(ans)