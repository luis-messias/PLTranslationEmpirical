import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the length, S is the string
    N = int(data[0])
    S = data[1]

    # Check if the string contains any character other than '4' or '7'
    if any(c not in '47' for c in S):
        print("NO")
        return

    # Calculate the sum of the first half (X)
    N_half = N // 2
    X = sum(int(c) for c in S[:N_half])

    # Calculate the sum of the second half (Y)
    Y = sum(int(c) for c in S[N_half:])

    # Compare the sums
    if X == Y:
        print("YES")
    else:
        print("NO")

solve()