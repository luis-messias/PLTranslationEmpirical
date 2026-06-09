def solve():
    import sys
    # Read two integers from standard input
    try:
        line = sys.stdin.read().strip()
        if not line:
            return
        a, b = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might not be two integers
        return

    sum_val = 0
    
    # The loop runs exactly twice (for i=0 and i=1)
    for _ in range(2):
        if a >= b:
            sum_val += a
            a -= 1
        else:
            sum_val += b
            b -= 1
            
    print(sum_val)

solve()