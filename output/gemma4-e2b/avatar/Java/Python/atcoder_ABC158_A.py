import sys

def solve():
    # Read the input string from standard input
    try:
        # Read the line and strip whitespace
        s = sys.stdin.readline().strip()
    except:
        # Handle potential empty input
        return

    # Check if the string contains both 'A' and 'B'
    if "A" in s and "B" in s:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    solve()