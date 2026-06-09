import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n is the first element, k is the second
    n = int(data[0])
    k = int(data[1])
    
    # arr elements start from index 2
    arr = [int(x) for x in data[2:n+2]]
    
    arr.sort()
    
    count = 0
    s = set()
    
    for x in arr:
        if x % k != 0:
            count += 1
            s.add(x)
        else:
            # x % k == 0
            if (x // k) not in s:
                count += 1
                s.add(x)
                
    print(count)

solve()