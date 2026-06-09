import sys

def min_func(arr, n):
    if n == 1:
        return 0
    if n == 2:
        return abs(arr[n - 1] - arr[n - 2])
    
    # Recursive step
    # op1 = |arr[n-1] - arr[n-2]| + min(arr, n-1)
    op1 = abs(arr[n - 1] - arr[n - 2]) + min_func(arr, n - 1)
    
    # op2 = |arr[n-1] - arr[n-3]| + min(arr, n-2)
    op2 = abs(arr[n - 1] - arr[n - 3]) + min_func(arr, n - 2)
    
    return min(op1, op2)

def dpc(arr, i, n, row):
    if row == n:
        return 0
    
    j, k = -1, -1
    
    if i == 1:
        j, k = 0, 2
    elif i == 0:
        j, k = 1, 2
    else:  # i == 2
        j, k = 0, 1
        
    return arr[row][i] + max(dpc(arr, j, n, row + 1), dpc(arr, k, n, row + 1))

def dpx(arr, n):
    if n == 0:
        return 0
        
    # dp[i][j] stores the maximum value ending at row i, column j
    dp = [[0] * 3 for _ in range(n)]
    
    # Base case: Row 0
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]
    
    for i in range(1, n):
        for in_col in range(3):
            j, k = -1, -1
            
            if in_col == 1:
                j, k = 0, 2
            elif in_col == 0:
                j, k = 1, 2
            else:  # in_col == 2
                j, k = 0, 1
            
            # Transition: dp[i][in_col] = max(dp[i-1][k], dp[i-1][j]) + arr[i][in_col]
            dp[i][in_col] = max(dp[i - 1][k], dp[i - 1][j]) + arr[i][in_col]
            
    # Result is the maximum value in the last row
    return max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2]))

def main():
    # Read input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    sc = iter(data)
    
    try:
        n = int(next(sc))
    except StopIteration:
        return

    arr = []
    for _ in range(n):
        row = []
        for _ in range(3):
            row.append(int(next(sc)))
        arr.append(row)

    ans = dpx(arr, n)
    print(ans)

if __name__ == "__main__":
    main()