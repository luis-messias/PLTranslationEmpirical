import sys

def main():
    try:
        # Read all inputs from standard input
        input_data = sys.stdin.read().split()
        if len(input_data) >= 2:
            a = int(input_data[0])
            b = int(input_data[1])
            print(a + b)
    except EOFError:
        pass

if __name__ == "__main__":
    main()