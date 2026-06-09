import sys

def main():
    # Read all input tokens from stdin
    input_tokens = sys.stdin.read().split()

    if not input_tokens:
        return

    try:
        # The first token is count
        count = int(input_tokens[0])
    except ValueError:
        return

    if len(input_tokens) < count + 1:
        # Not enough numbers provided
        return

    givingNumbers = []
    try:
        # Extract the next 'count' tokens as numbers
        for i in range(1, count + 1):
            givingNumbers.append(int(input_tokens[i]))
    except ValueError:
        return

    # Reversing the numbers and printing them separated by spaces
    # givingNumbers[::-1] reverses the list
    # * unpacks the list elements to be passed as arguments to print
    print(*(givingNumbers[::-1]))

if __name__ == "__main__":
    main()