import sys

def solve():
    # Read T, S, q from standard input
    try:
        # Read T
        T = int(sys.stdin.readline())
        # Read S
        S = int(sys.stdin.readline())
        # Read q
        q = int(sys.stdin.readline())
    except:
        # Handle potential empty input if running in certain environments
        return

    previous = S
    answer = 0

    # The loop calculates how many multiplications by q are needed 
    # starting from S until the result is >= T.
    while previous < T:
        answer += 1
        previous *= q

    print(answer)

solve()