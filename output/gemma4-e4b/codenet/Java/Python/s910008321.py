import sys

def main():
    try:
        # Read all inputs from standard input
        data = sys.stdin.read().split()
        if not data:
            return

        h = int(data[0])
        a = int(data[1])

        if h % a == 0:
            print(h // a)
        else:
            print(h // a + 1)
    except EOFError:
        pass
    except Exception:
        pass

if __name__ == "__main__":
    main()