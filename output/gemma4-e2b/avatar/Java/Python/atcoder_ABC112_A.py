import sys

def main():
    # Read all input lines
    lines = sys.stdin.readlines()
    
    if not lines:
        return

    try:
        # Read n (corresponds to read(1)[0])
        n = int(lines[0].strip())
    except ValueError:
        # Handle case where the first line is not an integer
        return

    if n == 1:
        print("Hello World")
    else:
        # Read strs (corresponds to read(2))
        if len(lines) >= 3:
            try:
                # Parse the next two lines
                s1 = int(lines[1].strip())
                s2 = int(lines[2].strip())
                print(s1 + s2)
            except ValueError:
                # Handle case where subsequent lines are not integers
                pass

if __name__ == "__main__":
    main()