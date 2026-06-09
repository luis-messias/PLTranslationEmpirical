import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        n = int(data[0])
        s = data[1]
    except ValueError:
        # Handle case where conversion fails
        return

    # 1. Count R, G, B
    rc = s.count('R')
    gc = s.count('G')
    bc = s.count('B')

    # 2. Initial result
    result = rc * gc * bc

    # 3. Nested loops (1-based indexing logic translated to 0-based access)
    # The loops run from i=1 to n and k=i+1 to n.
    for i in range(1, n + 1):
        for k in range(i + 1, n + 1):
            if (i + k) % 2 == 0:
                # Indices in Java (1-based) map to 0-based indices:
                # i -> i-1
                # k -> k-1
                # (i+k)/2 -> (i+k)/2 - 1
                
                idx_i = i - 1
                idx_k = k - 1
                idx_mid = (i + k) // 2 - 1
                
                is_char = s[idx_i]
                ks_char = s[idx_k]
                js_char = s[idx_mid]
                
                # Check if the three characters are mutually distinct
                if is_char != ks_char and ks_char != js_char and js_char != is_char:
                    result -= 1

    print(result)

solve()