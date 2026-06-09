import sys

def find_s(k, i):
    """Calculates the exponent of i in the prime factorization of k."""
    s = 0
    j = k
    while j % i == 0:
        s += 1
        j //= i
    return s

def main():
    # Read N from standard input
    try:
        # Assuming input is provided on a single line
        n_line = sys.stdin.readline()
        if not n_line:
            return
        n = int(n_line.strip())
    except Exception:
        return

    ans = 1
    mod = 10**9 + 7

    # Outer loop: i from 2 to n
    for i in range(2, n + 1):
        # The original Java loop structure is complex but only executes the body when j == i.
        # We simplify this by iterating j up to i and checking the condition.
        for j in range(2, i + 1):
            if j == i:
                # Calculate s = sum(findS(k, i) for k in 1 to n)
                s