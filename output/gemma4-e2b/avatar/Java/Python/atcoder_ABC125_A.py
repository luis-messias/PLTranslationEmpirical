import sys

def solve():
    # Read all inputs from stdin
    try:
        # Read the three integers/doubles sequentially
        sec = int(sys.stdin.readline())
        per_num = int(sys.stdin.readline())
        max_sec_base = int(sys.stdin.readline())
    except:
        # Handle case where input might be missing or malformed
        return

    # Calculate max_sec as in Java: (double) sc.nextInt() + 0.5
    max_sec = max_sec_base + 0.5
    
    ans_num = 0
    
    # Loop: for ( int i = sec ; i < max_sec ; i += sec )
    i = sec
    while i < max_sec:
        ans_num += per_num
        i += sec
        
    print(ans_num)

solve()