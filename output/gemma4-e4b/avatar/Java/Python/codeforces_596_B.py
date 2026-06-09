import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # N is the first element
        n = int(data[0])
    except ValueError:
        # Handle case where N might not be an integer
        return

    if n == 0:
        print(0)
        return

    # Array elements are the next N elements
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    arr = [int(x) for x in data[1:n+1]]
    
    # Calculate the answer: |arr[0]| + sum(|arr[i] - arr[i-1]|)
    answer = abs(arr[0])
    
    for i in range(1, n):
        answer += abs(arr[i] - arr[i-1])
    
    print(answer)

solve()