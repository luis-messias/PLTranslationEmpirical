import sys

def solve():
    # Read n and k from standard input
    try:
        # Read n
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
        
        # Read k
        k_line = sys.stdin.readline()
        if not k_line:
            return
        k = int(k_line.strip())
    except EOFError:
        return
    except ValueError:
        # Handle case where input is not an integer
        return

    i = 1
    req = 1

    # The loop continues as long as k is greater than or equal to the required subtraction amount (req)
    while k >= req:
        k = k - req
        i += 1
        
        # Update req based on i and n
        if i % n != 0: