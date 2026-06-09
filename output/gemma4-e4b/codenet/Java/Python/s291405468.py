import sys

def solve():
    # Read all input data and split it into tokens
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        # Handle case where not enough input is provided
        return

    try:
        # The first integer read corresponds to the first sc.nextInt()
        n1 = int(data[0])
        # The second integer read corresponds to the second sc.nextInt()
        n2 = int(data[1])
    except ValueError:
        # Handle non-integer input
        return

    # Evaluate the condition: (n1 % 500) <= n2
    if (n1 % 500) <= n2:
        print("Yes")
    else:
        print("No")

solve()