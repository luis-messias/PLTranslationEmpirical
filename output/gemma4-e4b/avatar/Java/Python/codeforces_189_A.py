import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the target sum
    N = int(data[0])
    # A, B, C are the costs
    A = int(data[1])
    B = int(data[2])
    C = int(data[3])

    costs = [A, B, C]

    # dp[i] stores the maximum number of items that sum up to i.
    # Initialize with -1 to represent unreachable states.
    dp = [-1] * (N + 1)
    dp[0] = 0

    # Iterate over the available costs (items)
    for cost in costs:
        # Iterate over possible sums j, starting from the cost itself
        for j in range(cost, N + 1):
            # If the state j - cost was reachable
            if dp[j - cost] != -1:
                # Update dp[j] with the maximum count found so far
                dp[j] = max(dp[j], dp[j - cost] + 1)

    print(dp[N])

solve()