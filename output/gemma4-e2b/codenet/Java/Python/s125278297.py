import sys

def main():
    # Read h and w from the first line
    try:
        # Read the first line containing h and w
        line = sys.stdin.readline()
        if not line:
            return
        h, w = map(int, line.split())
    except ValueError:
        # Handle case where h and w are not provided correctly
        return

    ans = []
    # Read the next h tokens (characters)
    for _ in range(h):
        try:
            char = sys.stdin.readline().strip()
            if char is not None:
                ans.append("#" + char + "#")
        except EOFError:
            break

    # Print the line of '#'s of length w + 2
    print("#" * (w + 2))

    # Print the generated strings
    for s in ans:
        print(s)

    # Print the final line of '#'s of length w + 2
    print("#" * (w + 2))

if __name__ == "__main__":
    main()