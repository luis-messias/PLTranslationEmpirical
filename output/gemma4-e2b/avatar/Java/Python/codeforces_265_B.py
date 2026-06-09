import sys

def solve():
    # Read all input from stdin and split into tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        return # Handle case where N is not an integer

    if n == 0:
        return

    # The remaining elements form the array arr
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    arr = [int(x) for x in data[1:n+1]]
    
    if len(arr) != n:
        # Safety check, though usually guaranteed by input format
        return

    # Java logic:
    # int ans = arr[0] + 1;
    ans = arr[0] + 1
    
    # for ( int i = 1 ; i < arr.length ; i ++ ) { ans += Math.abs ( arr [ i ] - arr [ i - 1 ] ) + 2 ; }
    for i in range(1, n):
        # ans += Math.abs(arr[i] - arr[i - 1]) + 2
        ans += abs(arr[i] - arr[i - 1]) + 2
        
    print(ans)

solve()