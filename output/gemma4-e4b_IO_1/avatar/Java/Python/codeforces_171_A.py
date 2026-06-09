import sys

def reverse(n: int) -> int:
    """Reverses the digits of an integer n, following the specific logic of the Java source."""
    # Java logic: if n < 10, return n * 10
    if n < 10:
        return n * 10
    
    t = n
    r = 0
    while t > 0:
        r = (r * 10) + (t % 10)
        t //= 10
    return r

def main():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    # n is the first argument, m is the second argument
    n = int(data[0])
    m = int(data[1])

    t = reverse(m)
    
    # The Java code prints t + n, which implies string concatenation.
    print(str(t) + str(n))

if __name__ == "__main__":
    main()
