import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        N = int(data[0])
    except IndexError:
        return

    # The next N elements are the array elements
    if N == 0:
        return
        
    arr = [int(x) for x in data[1:N+1]]
    
    # Initialization: ans = arr[0] + 1
    ans = arr[0] + 1
    
    # Loop calculation: ans += |arr[i] - arr[i-1]| + 2
    for i in range(1, N):
        diff = abs(arr[i] - arr[i-1])
        ans += diff + 2
        
    print(ans)

if __name__ == "__main__":
    solve()