import sys

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is the count
        count = int(data[0])
    except ValueError:
        return

    # Extract the numbers (tokens 1 through count)
    giving_numbers = []
    for i in range(1, count + 1):
        if i < len(data):
            try:
                giving_numbers.append(int(data[i]))
            except ValueError:
                # Stop if input format is incorrect
                break
        else:
            break
            
    # Print the numbers in reverse order, separated by spaces
    # The * operator unpacks the reversed list elements as arguments to print,
    # which automatically handles space separation and a final newline.
    print(*(giving_numbers[::-1]))

if __name__ == "__main__":
    main()