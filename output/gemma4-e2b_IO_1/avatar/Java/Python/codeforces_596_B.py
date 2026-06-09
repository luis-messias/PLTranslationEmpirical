import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where N is not provided correctly
        return

    if n == 0:
        print(0)
        return

    # The remaining tokens are the array elements
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    arr = [int(x) for x in data[1:n+1]]
    
    if not arr:
        # Should not happen if n > 0 and input is correct, but safety check
        return

    # Calculate the result: |arr[0]| + sum(|arr[i] - arr[i-1]|)
    
    # Initialize answer with |arr[0]|
    answer = abs(arr[0])
    
    # Add the sum of absolute differences between adjacent elements
    for i in range(1, n):
        answer += abs(arr[i] - arr[i-1])
        
    print(answer)

solve()
