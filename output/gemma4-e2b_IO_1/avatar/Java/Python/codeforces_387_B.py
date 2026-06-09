import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and M are the first two elements
    n = int(data[0])
    m = int(data[1])
    
    # req elements start from index 2
    req = [int(x) for x in data[2 : 2 + n]]
    
    # pre elements start after req elements
    pre = [int(x) for x in data[2 + n : 2 + n + m]]
    
    i = n - 1
    j = m - 1
    ans = 0
    
    # Two-pointer logic
    while i >= 0 and j >= 0:
        if req[i] > pre[j]:
            ans += 1
        else:
            j -= 1
        i -= 1
        
    # The result is ans + i + 1
    print(ans + i + 1)

solve()
