import sys

def main():
    # Reading N (equivalent to scanner.nextInt())
    try:
        # Read N from the first line
        n_line = sys.stdin.readline()
        if not n_line:
            return
        N = int(n_line.strip())
    except ValueError:
        return

    # Consuming the rest of the line (equivalent to scanner.nextLine() after nextInt())
    # Reading the string s from the second line
    s = sys.stdin.readline().strip()

    # Initialization matching Java variables
    ans = 0
    sha = 0
    dot = 0
    first = True

    for i in range(N):
        char = s[i]
        
        if char == '#':
            first = False
            
            if sha <= dot:
                ans += sha
                sha = 0
                dot = 0
                first = True
            
            sha += 1
        else:
            dot += 1

    # Post-loop logic
    if sha <= dot:
        ans += sha
        dot = 0

    print(ans + dot)

if __name__ == "__main__":
    main()