import sys

def generate_string():
    sb = []
    for i in range(1, 1001):
        sb.append(str(i))
    return "".join(sb)

def main():
    # Read the integer n from standard input
    try:
        # Read the entire input and strip whitespace, assuming n is the only input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except ValueError:
        return

    full_string = generate_string()

    # The Java code prints generateString()[n - 1]
    # We check bounds just in case, although for typical constraints n >= 1
    if 0 <= n - 1 < len(full_string):
        print(full_string[n - 1])

if __name__ == "__main__":
    main()