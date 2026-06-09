import sys

def solve():
    # Read all input data from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        # The first element is N
        n = int(input_data[0])
    except ValueError:
        return

    if n == 0:
        # If N=0, the loop range is empty, count remains 0. Output is 1.
        print(1)
        return

    # Read the array A
    if len(input_data) < n + 1:
        return
        
    a = [int(x) for x in input_data[1:n+1]]
    
    # 1. Sort the array
    a.sort()
    
    # 2. Initialize variables
    sum_val = 0
    count = 0
    
    # 3. Iterate and apply the logic
    # The loop runs for i from 0 to n-2
    for i in range(n - 1):
        sum_val += a[i]
        
        # Check the condition: a[i+1] <= 2 * sum_val
        if a[i+1] <= 2 * sum_val:
            count += 1
        else:
            count = 0
            
    # Print count + 1
    print(count + 1)

if __name__ == "__main__":
    solve()
