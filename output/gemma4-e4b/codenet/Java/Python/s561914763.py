import sys

def solve():
    # Initialize sets (equivalent to static initialization in Java)
    ODD = {"R", "U", "D"}
    EVE = {"L", "U", "D"}

    try:
        # Read input from standard input
        N = sys.stdin.read().strip()
    except EOFError:
        N = ""

    if not N:
        print("Yes") # Assuming empty input is valid if no constraints are given, though usually input is guaranteed.
        return

    is_good = True
    
    # Iterate through the string using index i (0-based) and character char
    for i, char in enumerate(N):
        # Check parity of the 0-based index i
        if i % 2 == 0:
            # Even index (0, 2, 4, ... corresponds to 1st, 3rd, 5th position)
            if char not in ODD:
                is_good = False
                break
        else:
            # Odd index (1, 3, 5, ... corresponds to 2nd, 4th, 6th position)
            if char not in EVE:
                is_good = False
                break

    print("Yes" if is_good else "No")

if __name__ == "__main__":
    solve()