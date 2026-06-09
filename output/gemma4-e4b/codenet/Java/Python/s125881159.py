import sys

def solve():
    # Read N (the count of numbers to follow)
    try:
        # Reading the first integer N
        n = int(sys.stdin.readline())
    except:
        # Handle case where input might be empty
        return

    d = 0
    
    # Loop N times to read the subsequent integers
    for _ in range(n):
        try:
            # Read the next integer
            line = sys.stdin.readline()
            if not line:
                break
            num = int(line)
            
            # Calculate parity (num % 2) and add to d
            d += num % 2
        except ValueError:
            # Stop if reading fails
            break
    
    # Check if the total sum of parities (d) is even or odd
    if d % 2 == 0:
        print("YES")
    else:
        print("NO")

solve()