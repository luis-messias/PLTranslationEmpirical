import sys

def solve():
    # Read the single long integer input
    try:
        # Reading all input and stripping ensures compatibility with various execution environments
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        number = int(input_data)
    except EOFError:
        return
    except ValueError:
        # Handle case where input might not be a valid integer
        return

    value =