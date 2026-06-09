import sys

def solve():
    # Read the single integer input n
    try:
        # Read all input and strip whitespace
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except EOFError:
        return
    except ValueError:
        # Handle case where input might not be a valid integer
        return

    # The problem asks for the count of set bits (1s) in the binary representation of n.
    # Python's bin(n) returns a string like '0b1101'. We count '1's in this string.
    # This is the most direct and efficient way to solve the problem.
    print(bin(n).count('1'))

solve()