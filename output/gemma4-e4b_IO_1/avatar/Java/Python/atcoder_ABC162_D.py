import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, S is the second element
    n = int(data[0])
    s = data[1]

    # Count R, G, B
    rc = s.count('R')
    gc = s.count('G')
    bc = s.count('B')

    result = rc * gc * bc

    # Iterate through pairs (i, k) where 1 <= i < k <= n
    for i in range(1, n + 1):
        for k in range(i + 1, n + 1):
            # Check if i + k is even
            if (i + k) % 2 == 0:
                # Indices are 0-based, positions i and k are 1-based.
                is_char = s[i - 1]
                ks_char = s[k - 1]
                
                # Index for the middle element j = (i + k) / 2
                js_index = ((i + k) // 2) - 1
                js_char = s[js_index]
                
                # Check if the three characters are distinct
                if is_char != ks_char and ks_char != js_char and js_char != is_char:
                    result -= 1

    print(result)

solve()
