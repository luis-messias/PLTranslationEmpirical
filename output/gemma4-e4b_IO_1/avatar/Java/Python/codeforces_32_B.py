import sys

def solve():
    # Read the single input string from standard input
    try:
        # Read all input and strip whitespace
        input_data = sys.stdin.read().strip()
    except Exception:
        return

    if not input_data:
        return

    n = input_data
    s = False
    output = []

    for char in n:
        if char == '.':
            if s:
                output.append('1')
                s = False
            else:
                output.append('0')
        else:  # char is not '.'
            if s:
                output.append('2')
                s = False
            else:
                # Only state changes, no output printed
                s = True

    sys.stdout.write("".
