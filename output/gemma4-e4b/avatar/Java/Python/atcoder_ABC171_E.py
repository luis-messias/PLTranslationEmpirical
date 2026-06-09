import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # A contains the next N elements
    A = [int(x) for x in data[1:N+1]]
    
    # Calculate r (XOR sum of all elements in A)
    r = 0
    for x in A:
        r ^= x
        
    # Calculate results: r ^ a[i] for all a[i]
    results = []
    for x in A:
        results.append(r ^ x)
        
    # Print results separated by spaces
    print(*(results))

if __name__ == "__main__":
    solve()