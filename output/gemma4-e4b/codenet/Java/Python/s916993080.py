import sys

def solve():
    # Read all input numbers from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Iterator for reading numbers sequentially
    data_iter = iter(input_data)

    try:
        n = int(next(data_iter))
    except StopIteration:
        # Handle case where N might not be provided
        return

    # Read the array arr[n][3]
    arr = []
    for i in range(n):
        row = []
        for j in range(3):
            try:
                row.append(int(next(data_iter)))
            except StopIteration:
                # Should not happen if input matches expected format
                return
        arr.append(row)

    if n == 0:
        print(0) # Or handle based on expected output for N=0
        return

    # Initialize DP table
    # dp[i][j] stores the max sum ending at row i, choosing element j
    dp = [[0] * 3 for _ in range(n)]

    # Base case i = 0
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]

    # Transitions i = 1 to n-1
    for i in range(1, n):
        # j = 0 (Current element arr[i][0])
        # Must come from j=1 or j=2 in the previous row
        dp[i][0] = max(arr[i][0] + dp[i-1][1], arr[i][0] + dp[i-1][2])

        # j = 1 (Current element arr[i][1])
        # Must come from j=0 or j=2 in the previous row
        dp[i][1] = max(arr[i][1] + dp[i-1][0], arr[i][1] + dp[i-1][2])

        # j = 2 (Current element arr[i][2])
        # Must come from j=0 or j=1 in the previous row
        dp[i][2] = max(arr[i][2] + dp[i-1][0], arr[i][2] + dp[i-1][1])

    # Find the maximum value in the last row
    max_val = max(dp[n-1])
    print(max_val)

solve()