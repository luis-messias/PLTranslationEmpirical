import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    n = int(data[0])
    
    # The remaining tokens are the values
    values = [int(x) for x in data[1:]]
    
    # 1. Count frequencies
    hm = {}
    for val in values:
        hm[val] = hm.get(val, 0) + 1
        
    ans = 0
    
    # 2. Calculate the result based on the logic
    for val, num in hm.items():
        if num > val:
            ans += num - val
        elif num < val:
            ans += num
            
    print(ans)

solve()