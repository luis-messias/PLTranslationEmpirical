import sys

def is_even_string(s):
    """Checks if the first half of the even-length string equals the second half."""
    L = len(s)
    if L == 0:
        return False
    
    mid = L // 2
    a = s[:mid]
    b = s[mid:]
    return a == b

def solve():
    # Read input from stdin
    try:
        # Read the entire line of input
        S = sys.stdin.read().strip()
    except EOFError:
        S = ""

    L = len(S)

    # Initial truncation logic
    if L % 2 == 1:
        # Odd length: remove last character
        S = S[:L - 1]
    else:
        # Even length: remove last two characters
        S = S[:L - 2]

    # Main loop
    while len(S) > 0:
        if is_even_string(S):
            break
        
        # Shorten S by 2 characters
        S = S[:-2]

    print(len(S))

if __name__ == "__main__":
    solve()