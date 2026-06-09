import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    try:
        N = int(data[0])
    except ValueError:
        return # Handle case where N is not an integer

    # The remaining elements are the array A
    if len(data) < N + 1:
        # Not enough input elements provided
        return
        
    A = [int(x) for x in data[1:N+1]]

    min_abs = float('inf')
    count = 0
    total_sum = 0

    for x in A:
        if x < 0:
            count += 1
        
        abs_x = abs(x)
        
        min_abs = min(min_abs, abs_x)
        total_sum += abs_x

    if count % 2 == 0:
        print(total_sum)
    else:
        print(total_sum - min_abs * 2)

solve()