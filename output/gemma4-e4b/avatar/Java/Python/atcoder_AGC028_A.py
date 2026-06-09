import math
import sys

def solve():
    # Read all inputs from stdin. Assuming the format is:
    # n m
    # s
    # t
    try:
        data = sys.stdin.read().split()
        if not data:
            return

        n = int(data[0])
        m = int(data[1])
        s = data[2]
        t = data[3]
    except Exception:
        # Handle potential reading errors if input format is unexpected
        return

    g = math.gcd(n, m)
    
    mismatch_found = False
    
    # Check for mismatches for k = 0 to g-1
    for k in range(g):
        # Calculate indices: k * n / g and k * m / g
        idx_s = (k * n) // g
        idx_t = (k * m) // g
        
        if s[idx_s] != t[idx_t]:
            mismatch_found = True
            break
            
    if mismatch_found:
        print(-1)
    else:
        # Calculate LCM: (n * m) / g
        lcm = (n * m) // g
        print(lcm)

if __name__ == "__main__":
    solve()