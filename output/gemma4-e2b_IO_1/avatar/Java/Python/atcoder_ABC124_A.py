import sys

def solve():
    # Read input from stdin, expecting two space-separated integers
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        a = int(data[0])
        b = int(data[1])
    except:
        return

    sum_val = 0
    
    # The loop runs exactly 2 times
    for _ in range(2):
        if a >= b:
            sum_val += a
            a -= 1
        else:
            sum_val += b
            b -= 1
            
    print(sum_val)

solve()
