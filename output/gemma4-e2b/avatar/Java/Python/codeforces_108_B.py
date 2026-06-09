import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
    except ValueError:
        return # Handle case where N is not an integer

    if len(data) < n + 1:
        return # Not enough elements provided

    # Read the array A
    a = [int(x) for x in data[1:n+1]]
    
    # Sort the array
    a.sort()
    
    # Check the condition
    for i in range(len(a) - 1):
        # Check if a[i+1] < 2 * a[i] AND a[i] != a[i+1]
        if a[i + 1] < a[i] * 2 and a[i] != a[i + 1]:
            print("YES")
            return
            
    print("NO")

solve()