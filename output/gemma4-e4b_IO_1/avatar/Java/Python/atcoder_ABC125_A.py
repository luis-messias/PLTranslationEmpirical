import sys

def solve():
    # Read all space-separated integers from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        sec = int(data[0])
        per_num = int(data[1])
        max_sec_input = int(data[2])
    except Exception:
        return

    # Calculate max_sec as per Java logic: (double) sc.nextInt() + 0.5
    max_sec = float(max_sec_input) + 0.5
    
    ans_num = 0
    
    # Loop structure: for ( int i = sec ; i < max_sec ; i += sec )
    i = sec
    while i < max_sec:
        ans_num += per_num
        i += sec
        
    print(ans_num)

solve()
