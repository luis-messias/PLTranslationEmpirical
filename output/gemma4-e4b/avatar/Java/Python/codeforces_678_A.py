import sys

def solve():
    # Read all inputs from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        n = int(data[0])
        k = int(data[1])
    except EOFError:
        return
    except IndexError:
        return

    # The original Java code increments n first: n++
    n += 1
    
    z = 0
    
    # Check if n is not divisible by k
    if n % k != 0:
        # Calculate the difference needed to make it divisible
        z = k - (n % k)
    
    # Print the result (n + z)
    print(n + z)

solve()