import sys

def solve():
    # Read all input from stdin and split into tokens
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        # Assuming the input is a single pair N M based on the example
        n = int(data[0])
        m = int(data[1])
    except ValueError:
        # Handle case where input might be malformed
        return

    if n == 0:
        print(0)
        return

    if n == m:
        print(0)
        return

    if n > m:
        # Java logic:
        # n = m + n % m;
        # n -= m;  => n becomes n % m
        n_mod_m = n % m
        result = min(m - n_mod_m, n_mod_m)
        print(result)
    else:  # n < m
        # Java logic:
        # pw.println(Math.min(m-n,n));
        result = min(m - n, n)
        print(result)

solve()
