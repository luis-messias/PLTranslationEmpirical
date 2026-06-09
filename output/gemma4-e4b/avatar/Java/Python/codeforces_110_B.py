import sys

def solve():
    # Read N from standard input
    try:
        # Reading all input and stripping whitespace is robust for single integer input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except EOFError:
        return
    except ValueError:
        return

    c = [''] * n
    p = 97  # ASCII value for 'a'

    # Replicating the Java loop structure
    for i in range(4):
        for j in range(i, n, 4):
            c[j] = chr(p)
            p += 1

    # Print the resulting characters joined together
    print("".join(c))

solve()