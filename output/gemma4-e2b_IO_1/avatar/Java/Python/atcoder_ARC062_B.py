import sys

def solve():
    # Read the input string S. We assume the input is provided on a single line.
    try:
        # Read the entire input and strip whitespace
        S = sys.stdin.readline().strip()
    except:
        return

    if not S:
        return

    score = 0
    n = len(S)
    
    for i in range(n):
        # Determine 'my' based on index parity: 'g' if i is even, 'p' if i is odd
        my = 'g' if i % 2 == 0 else 'p'
        his = S[i]
        
        if my != his:
