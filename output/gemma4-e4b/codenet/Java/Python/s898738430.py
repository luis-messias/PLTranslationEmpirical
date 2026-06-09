import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        print(0)
        return

    # The first element is n
    try:
        n = int(input_data[0])
    except IndexError:
        # Should not happen if input is guaranteed, but safe guard
        print(0)
        return

    # The next n elements form the array a
    if n == 0:
        print(0)
        return
        
    try:
        a = [int(x) for x in input_data[1:n+1]]
    except IndexError:
        # Handle case where not enough elements are provided
        if n > 0:
            a = [int(x) for x in input_data[1:]]
        else:
            a = []

    if n < 3:
        print(0)
        return

    ans = 0
    # Iterate from i=1 up to n-2 (inclusive)
    for i in range(1, n - 1):
        # The triplet is (a[i-1], a[i], a[i+1])
        triplet = (a[i-1], a[i], a[i+1])
        
        # Check if a[i] is neither the minimum nor the maximum of the triplet
        if a[i] != min(triplet) and a[i] != max(triplet):
            ans += 1
            
    print(ans)

solve()