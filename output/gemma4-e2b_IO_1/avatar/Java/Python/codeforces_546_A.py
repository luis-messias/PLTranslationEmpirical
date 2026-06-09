import sys

def solve():
    # Read inputs: pandu, vundu, urdu
    try:
        # Read pandu
        line = sys.stdin.readline()
        if not line:
            return
        pandu = int(line.strip())
        
        # Read vundu
        line = sys.stdin.readline()
        if not line:
            return
        vundu = int(line.strip())
        
        # Read urdu
        line = sys.stdin.readline()
        if not line:
            return
        urdu = int(line.strip())
    except ValueError:
        # Handle case where input is not an integer
        return

    # Calculate the sum of integers from 1 to urdu: sum = urdu * (urdu + 1) / 2
    # Use integer division //
    sum_series = urdu * (urdu + 1) // 2
    
    # Calculate c = pandu * sum_series
    c = pandu * sum_series

    # Determine the output
    if c < vundu:
        print("0")
    else:
        print(c - vundu)

solve()
