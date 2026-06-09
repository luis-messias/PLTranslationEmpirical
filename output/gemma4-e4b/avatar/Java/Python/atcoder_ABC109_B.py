import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        print("No")
        return

    try:
        N = int(data[0])
    except ValueError:
        # Handle case where N is not provided or invalid
        print("No")
        return

    # The N strings follow N
    S = data[1:N+1]
    
    if len(S) != N:
        # Input mismatch
        print("No")
        return

    ans = True
    past_strings = set()
    next_char = None

    for i in range(N):
        current_string = S[i]

        # Check 1: Unique Strings (No repetition)
        if current_string in past_strings:
            ans = False
            break
        past_strings.add(current_string)

        # Check 2: Overlap Constraint (If i > 0)
        if i > 0:
            # Check if the first character matches the previous last character
            if not current_string or current_string[0] != next_char:
                ans = False
                break

        # Update next_char (last character of current_string)
        if current_string:
            next_char = current_string[-1]

    if ans:
        print("Yes")
    else:
        print("No")

solve()