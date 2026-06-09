import sys

def solve():
    # Read all inputs from stdin, assuming they are provided space-separated on one line
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        a = int(data[0])
        b = int(data[1])
        t = int(data[2])
    except:
        return

    time = 0.0
    count = 0
    T_limit = t + 0.5

    while time < T_limit:
        count += b
        time += a
        
        if time > T_limit:
            count -= b
            break

    print(count)

solve()
