import sys

def main():
    # Read all inputs from standard input
    # In a typical competitive programming setup where two inputs are provided on separate lines or separated by spaces,
    # reading them sequentially using input() or sys.stdin.read().split() is common.
    # Since the Java code uses in.next() twice, it expects two space-separated tokens.
    try:
        # Read the two tokens from standard input
        input_data = sys.stdin.read().split()
        if len(input_data) < 2:
            return

        a = input_data[0]
        b = input_data[1]
        
        # Print b followed by a
        print(b + a)
    except EOFError:
        pass

if __name__ == "__main__":
    main()