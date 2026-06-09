import sys

def solve():
    # Read all inputs from stdin and split them into tokens
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        w = int(data[0])
        a = int(data[1])
        b = int(data[2])
    except:
        return

    # Calculate |a - b| - w
    answer = abs(a - b) - w
    
    # Print max(0, answer)
    print(max(0, answer))

solve()