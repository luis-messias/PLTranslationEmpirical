import sys

def solve():
    # Read N from standard input
    try:
        # Reading the single integer input
        N = int(sys.stdin.read().strip())
    except:
        # Handle case where input might be missing
        return

    # Calculate number of digits (count)
    count = len(str(N))
    ans = 0

    # Loop through positions i (1-indexed)
    for i in range(1, count + 1):
        if i == count:
            # Case: Last position
            if count % 2 == 1:
                # ans += ( N - 10^(i-1) + 1 )
                ans += (N - (10**(i - 1)) + 1)
        else:
            # Case: Not the last position
            if i == 1:
                # ans += 9
                ans += 9
            elif i % 2 == 1:
                # ans += ( 10^i - 10^(i-1) )
                ans += (10**i - 10**(i - 1))

    print(ans)

solve()