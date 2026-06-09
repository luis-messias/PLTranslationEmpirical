import sys

def solve():
    # Read all input tokens from stdin
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        # Handle case of no input
        print("NO")
        return

    if not data:
        print("NO")
        return

    # 1. Get distinct and sorted elements
    a = sorted(list(set(data)))
    
    found = False
    n = len(a)
    
    # 2. Check for consecutive triplets (a[i], a[i+1], a[i+2])
    if n >= 3:
        for i in range(n - 2):
            # Check if a[i], a[i+1], a[i+2] are consecutive integers
            if a[i+1] == a[i] + 1 and a[i+2] == a[i+1] + 1:
                found =
