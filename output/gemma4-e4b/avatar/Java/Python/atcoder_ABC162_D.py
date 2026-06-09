import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, S is the second element
    n = int(data[0])
    s = data[1]

    # Count R, G, B
    rc = s.count('R')
    gc = s.count('G')
    bc = s.count('B')

    result = rc * gc * bc

    # Iterate through pairs (i, k) where 1 <= i < k <= n
    for i in range(1, n + 1):
        for k in range(i + 1, n + 1):
            # Check if i + k is