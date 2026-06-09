import sys

def solve():
    # Read all inputs from stdin and split them
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        sec = int(data[0])
        per_num = int(data[1])
        max_sec_base = int(data[2])
    except:
        return

    # Calculate max_sec = (double) sc.nextInt() + 0.5
    max_sec = max_sec_base + 0.5
    
    ans_num = 0
    
    # Loop: for ( int i = sec ; i < max_sec ; i += sec )
    i = sec
    while i < max_sec:
        ans_num += per_num
        i += sec
        
    print(ans_num)

solve()
