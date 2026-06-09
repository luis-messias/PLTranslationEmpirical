import sys

def reverse(n: int) -> int:
    """Reverses the digits of an integer n, following the specific logic of the Java source."""
    if n < 10:
        return n * 10
    
    t = n
    r = 0
    while t > 0:
        r = (r * 10) + (t % 10)
        t //= 10
    return r

def main():
    # Reading two integers from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        n = int(data[0])
        m = int(data[1])
    except Exception:
        # Handle potential empty input or parsing errors
        return

    t = reverse(m)
    
    # The Java code prints t + n, which implies string concatenation of the results.
    print(str(t) + str(n))

if __name__ == "__main__":
    main()