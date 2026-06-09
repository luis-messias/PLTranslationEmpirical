import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The array elements A are the next N elements
    # We use standard Python integers which handle large numbers automatically (equivalent to Java long)
    A = [int(x) for x in data[1:N+1]]
    
    # Calculate prefix sums: pre[i] stores the sum of the first i elements (A[0]...A[i-1])
    # pre array size N+1
    pre = [0] * (N + 1)
    current_sum = 0
    for i in range(N):
        current_sum += A[i]
        pre[i+1] = current_sum
        
    # Total sum S = pre[N]
    S = pre[N]
    
    min_diff = float('inf')
    
    # Iterate i from 1 to N-1 (split point)
    # i represents the size of the first partition
    for i in range(1, N):
        # val1 = sum of first i elements
        val1 = pre[i]
        
        # val2 = sum of remaining N-i elements
        val2 = S - val1
        
        diff = abs(val1 - val2)
        min_diff = min(min_diff, diff)
        
    print(min_diff)

if __name__ == "__main__":
    solve()