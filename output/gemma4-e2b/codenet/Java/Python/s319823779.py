import sys

def solve():
    # Read all inputs from stdin
    data = sys.stdin.read().split()
    
    if len(data) < 4:
        return

    try:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        x = int(data[3])
    except ValueError:
        # Handle case where input might not be integers
        return

    res = 0

    # Iterate through i from 0 to a
    for i in range(a + 1):
        # Iterate through j from 0 to b
        for j in range(b + 1):
            # Iterate through k from 0 to c
            for k in range(c + 1):
                total = 500 * i + 100 * j + 50 * k
                
                if total == x:
                    res += 1
        
        # Print the accumulated result after finishing the j and k loops for the current i
        print(res)

solve()