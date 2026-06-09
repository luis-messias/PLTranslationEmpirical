import sys

def solve():
    # Read the single integer input
    try:
        # Reading from stdin is the standard way to replicate Scanner behavior
        x = int(sys.stdin.read().strip())
    except:
        # Handle case where input might be empty
        return

    # Java logic:
    # bool = (x == 1)
    # result = !bool ? 1 : 0
    # This evaluates to 1 if x != 1, and 0 if x == 1.
    result = 1 if x != 1 else 0
    
    print(result)

solve()