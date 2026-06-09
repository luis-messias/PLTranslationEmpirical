import sys
import math

def solve():
    # Read input from stdin. Assuming n, a, b are provided sequentially.
    try:
        # Read n, a, b from standard input
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        n = int(data[0])
        a = int(data[1])
        b = int(data[2])
    except:
        # Handle potential errors during reading if input format is unexpected
        return

    sa = abs(a - b)
    ans = 0

    if sa % 2 == 0:
        ans = sa // 2
    else:
        # sa is odd
        
        # AAA = min((n-a), (a-1))
        AAA = min(n - a, a - 1)
        
        # BBB = min((n-b), (b-1))
        BBB = min(n - b, b - 1)

        # ans = min(AAA, BBB)
        ans = min(AAA, BBB)

        # 差を1減らす⇒差が偶数になる
        sa -= 1
        ans += 1

        # 差は偶数
        ans += sa // 2

    print(ans)

solve()