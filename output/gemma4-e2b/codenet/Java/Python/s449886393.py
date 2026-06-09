import sys

def main():
    # Read input from stdin
    try:
        s = sys.stdin.read().strip()
    except:
        # Fallback for environments where sys.stdin.read() might behave differently, though input() is usually sufficient.
        s = input()

    youbi = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    ans = 0

    # Find the index of the input string s
    try:
        i = youbi.index(s)
        # Calculate the result based on the index
        ans = 7 - i
        print(ans)
    except ValueError:
        # Handle case where s is not found in the list (optional, based on Java behavior)
        pass

if __name__ == "__main__":
    main()