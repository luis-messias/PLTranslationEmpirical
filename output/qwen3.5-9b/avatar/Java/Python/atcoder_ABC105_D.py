import sys
from collections import defaultdict

def solve():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    n = int(next(iterator))
    m = int(next(iterator))
    a = [int(next(iterator)) for _ in range(n)]
    
    dp = defaultdict(int)
    ans = 0
    base = 0
    
    for x in a:
        base = (base - x % m + m) % m
        dp[(base + x) % m] += 1
        ans += dp.get(base, 0)
    
    print(ans)

if __name__ == "__main__":
    solve()