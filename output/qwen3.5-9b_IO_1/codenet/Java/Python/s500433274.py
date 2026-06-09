import sys

def main():
    tokens = sys.stdin.read().split()
    for i in range(0, len(tokens), 2):
        if i + 1 < len(tokens):
            a = int(tokens[i])
            b = int(tokens[i + 1])
            if a > b:
                print("GREATER")
            elif b > a:
                print("LESS")
            else:
                print("EQUAL")

if __name__ == "__main__":
    main()
