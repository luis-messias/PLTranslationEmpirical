import sys

def solve():
    # Read all inputs from stdin, assuming they are provided sequentially
    data = sys.stdin.read().split()
    
    if len(data) < 3:
        return
        
    try:
        w = int(data[0])
        a = int(data[1])
        b = int(data[2])
    except ValueError:
        return

    # Calculate the result: max(a, b) - min(a, b) - w
    answer = max(a, b) - min(a, b) - w
    
    if answer < 0:
        print(0)
    else:
        print(answer)

solve()
