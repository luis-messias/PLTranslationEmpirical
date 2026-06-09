import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        return # Handle case where n is not an integer

    c = 0
    flg = 0
    data_ptr = 1

    # Loop n times, reading pairs (x, y)
    for _ in range(n):
        if data_ptr + 1 >= len(data):
            break
            
        try:
            x = int(data[data_ptr])
            y = int(data[data_ptr + 1])
            data_ptr += 2
        except ValueError:
            # Skip if x or y are not valid integers
            continue
        
        if x == y:
            c += 1
            if c >= 3:
                flg = 1
        else:
            c = 0

    if flg == 0:
        print("No")
    else:
        print("Yes")

solve()