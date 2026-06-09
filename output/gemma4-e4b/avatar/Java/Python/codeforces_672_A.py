import sys

def generate_string():
    """Generates a string by concatenating numbers from 1 to 1000."""
    s = ""
    for i in range(1, 1001):
        s += str(i)
    return s

def main():
    # Read the integer N from standard input
    try:
        # Read all input and strip whitespace, then convert to int
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        n = int(input_data)
    except EOFError:
        return
    except ValueError:
        return

    # Generate the full string
    full_string = generate_string()

    # The problem asks for the character at the N-th position (1-indexed), 
    # which corresponds to index N-1 in 0-based indexing.
    index = n - 1
    
    if 0 <= index < len(full_string):
        print(full_string[index])

if __name__ == "__main__":
    main()