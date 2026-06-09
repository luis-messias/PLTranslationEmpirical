import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        print("No") # Assuming no input means no sequence found
        return

    try:
        # The first element is N
        n = int(data[0])
    except ValueError:
        # If N cannot be read, assume no processing is needed
        print("No")
        return

    c = 0
    flg = 0
    
    # Data starts from index 1. We process N pairs (2*N elements).
    data_index = 1
    
    for i in range(n):
        # Check if we have enough data for the current pair
        if data_index + 1 >= len(data):
            break
            
        try:
            x = int(data[data_index])
            y = int(data[data_index + 1])
        except ValueError:
            # Should not happen if input is well-formed
            break
            
        data_index += 2
        
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