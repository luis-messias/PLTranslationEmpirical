import sys

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    try:
        n = int(data[0])
    except ValueError:
        return

    # The next N tokens are the elements
    elements_str = data[1:n+1]
    
    # Convert to integers and use a set to store unique values
    try:
        integer_set = set(map(int, elements_str))
    except ValueError:
        return

    # Print the size of the set
    print(len(integer_set))

if __name__ == "__main__":
    main()