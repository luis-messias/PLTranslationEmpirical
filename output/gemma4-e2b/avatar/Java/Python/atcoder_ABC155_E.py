import sys

def solve():
    # Read the input number from standard input
    try:
        number = sys.stdin.readline().strip()
    except:
        return

    if not number:
        return

    n = len(number)
    # Initialize digits array of size n + 1
    digits = [0] * (n + 1)

    # Extract digits in reverse order into digits[0]...digits[n-1]
    # digits[i] will hold the i-th digit from the right (0-indexed)
    for i in range(n):
        # number[n - 1 - i