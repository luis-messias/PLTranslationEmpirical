import sys

def solve():
    # Read the integer n from standard input
    try:
        # Read all lines and take the first one, assuming single input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except Exception:
        return

    # The Java logic is: (n / 3) * 2 + (n % 3 == 0 ? 0 : 1)
    # In Python, integer division is //
    # The ternary operator (condition ? 0 : 1) translates to (0 if condition else 1)
    result = (n // 3) * 2 + (0 if n % 3 == 0 else 1)
    print(result)

solve()