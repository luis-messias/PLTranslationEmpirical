import sys

def solve():
    # Read input from stdin. Assuming input is provided line by line or space separated.
    # Based on the prompt structure (kyoto, tokyo), we read the two strings.
    try:
        # Read all input and split into strings
        input_data = sys.stdin.read().split()
        if len(input_data) < 2:
            return
        
        s = input_data[0]
        t = input_data[1]
        
    except Exception:
        # Handle potential reading errors if input is unexpected
        return

    if len(s) != len(t):
        print("No")
        return

    # Check if t is a rotation of s. This is true if t is a substring of s + s.
    ss = s + s
    if t in ss:
        print("Yes")
    else:
        print("No")

solve()
