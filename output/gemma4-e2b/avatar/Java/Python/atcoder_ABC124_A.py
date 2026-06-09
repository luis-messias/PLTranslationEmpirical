import sys

def solve():
    # Read the two integers a and b from standard input
    try:
        a = int(sys.stdin.readline())
        b = int(sys.stdin.readline())
    except:
        # Handle potential empty input if running outside typical environment
        return

    sum_val = 0
    
    # The loop runs exactly 2 times (for i = 0 and i = 1)
    for _ in range(2):
        if a >= b:
            sum_val += a
            a -= 1
        else:
            sum_val += b
            b -= 1
            
    print(sum_val)

solve()