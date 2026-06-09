import sys
import math

def solve():
    # Read input N
    try:
        N = int(sys.stdin.readline())
    except:
        return

    count = 0
    temp = N
    
    # Calculate the number of digits (count)
    if N == 0:
        count = 1
    else:
        while temp > 0:
            temp //= 10
            count += 1
    
    ans = 0
    
    # Loop from i = 1 to count
    for i in range(1, count + 1):
        if i == count:
            if i % 2 == 1:
                # ans += (N - 10^(i - 1) + 1)
                ans += (N - (10**(i - 1)) + 1)
        else:
            if i == 1:
                ans += 9
            elif i % 2 == 1:
                # ans += (10^i - 10^(i - 1))
                ans += (10**i - 10**(i - 1))
                
    print(ans)

solve()