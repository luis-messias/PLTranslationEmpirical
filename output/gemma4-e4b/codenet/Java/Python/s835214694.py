import sys

def main():
    try:
        # Read all inputs from standard input
        input_data = sys.stdin.read().split()
        if not input_data:
            return

        a = int(input_data[0])
        b = int(input_data[1])

        if b % a == 0:
            print(a + b)
        else:
            print(b - a)
    except EOFError:
        pass
    except Exception:
        pass

if __name__ == "__main__":
    main()