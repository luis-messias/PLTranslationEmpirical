import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, M is the second
    n = int(data[0])
    m = int(data[1])
    
    # The remaining N elements are po
    po = [int(x) for x in data[2:2+n]]
    
    # Update m by subtracting all elements of po
    # This is equivalent to m = m - sum(po)
    for element in po:
        m -= element
        
    # Sort po
    po.sort()
    
    # Calculate and print the result
    # Use integer division (//) to match the expected output behavior (Java integer division).
    # The calculation is n + (m / po[0])
    result = n + (m // po[0])
    print(result)

solve()
