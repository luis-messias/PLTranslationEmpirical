import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is N
        n = int(data[0])
        
        # The next N elements form the array A
        if len(data) < n + 1:
            # Handle insufficient input
            return
            
        a = [int(x) for x in data[1:n+1]]
    except ValueError:
        # Handle parsing errors
        return

    # Sort the array
    a.sort()

    sum_val = 0
    count = 0

    # Iterate from i=0 to n-2
    for i in range(n - 1):
        # Update sum: sum += a[i]
        sum_val += a[i]
        
        # Check condition: a[i+1] <= 2 * sum
        if a[i+1] <= 2 * sum_val:
            count += 1
        else:
            count = 0
            
    # Print the result: count + 1
    print(count + 1)

if __name__ == "__main__":
    solve()