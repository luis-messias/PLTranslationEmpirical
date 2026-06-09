import sys

def solve():
    # Read n (integer)
    try:
        # Read the first line for n
        n_line = sys.stdin.readline().strip()
        if not n_line:
            return
        n = int(n_line)
    except Exception:
        return

    # Read str (string)
    try:
        # Read the second line for the string
        str_val = sys.stdin.readline().strip()
    except Exception:
        str_val = ""

    # Calculate the first half of the string, using n as the length indicator
    # Python slicing handles this directly: str_val[:k] gets the first k characters.
    a = str_val[:n // 2]

    # Check if str_val equals the concatenation of a with itself
    if str_val == a + a:
        print("Yes")
    else:
        print("No")

solve()