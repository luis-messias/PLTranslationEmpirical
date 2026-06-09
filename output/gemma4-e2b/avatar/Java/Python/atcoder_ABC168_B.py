import sys

def solve():
    # Read K
    try:
        # Read K from the first line
        K = int(sys.stdin.readline())
    except:
        # Handle case where input might be empty
        return

    # Read S from the second line
    S = sys.stdin.readline().strip()

    if len(S) <= K:
        print(S)
    else:
        # S.substring(0, K) corresponds to S[:K] in Python
        print(S[:K] + "...")

solve()