import sys

MOD = 1000000007

def f(n):
    """Calculates n! mod MOD"""
    res = 1
    for i in range(2, n + 1):
        res = (res * i) % MOD
    return res

def solve():
    # Read the single line of input
    try:
        line = sys.stdin.readline().strip()
        if not line:
            return
        
        # Parse the two integers
        parts = line.split()
        if len(parts) < 2:
            return
            
        xx = [int(p) for p in parts]
        
    except Exception:
        # Handle potential errors during input reading/parsing
        return

    min_val = min(xx[0], xx[1])
    max_val = max(xx[0], xx[1])
    
    res = 0
    
    if min_val == max_val:
        # Case 1: min == max
        f_min = f(min_val)
        # res = (2 * f * f) % MOD
        res = (2 * f_min * f_min) % MOD
    elif min_val + 1 == max_val:
        # Case 2: min + 1 == max
        f_min = f(min_val)
        # Java calculation: res = (f*((f*max)%MOD))%MOD;
        # Equivalent to: f_min * ((f_min * max_val) % MOD) % MOD
        term = (f_min * max_val) % MOD
        res = (f_min * term) % MOD
    else:
        # Case 3: max > min + 1
        res = 0
        
    print(res)

if __name__ == "__main__":
    solve()