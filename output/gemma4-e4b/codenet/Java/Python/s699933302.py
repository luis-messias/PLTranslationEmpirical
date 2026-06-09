import sys

def solve():
    # Reading three integers from standard input, assuming they are space-separated
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
    except Exception:
        # Fallback for environments where reading all input is tricky
        # If running in an environment that expects single line input:
        try:
            a, b, c = map(int, input().split())
        except:
            return

    count = 0
    # Loop from a to b inclusive
    for i in range(a, b + 1):
        # Check if i divides c
        if c % i == 0:
            count += 1
    
    print(count)

solve()