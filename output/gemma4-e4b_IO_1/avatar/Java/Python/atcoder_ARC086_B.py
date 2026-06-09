import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # A contains the next N elements
    a = [int(x) for x in data[1:n+1]]

    r = []
    
    # 1. Find index m (0-based) corresponding to minimum absolute value
    m = 0
    for i in range(1, n):
        if abs(a[m]) > abs(a[i]):
            m = i

    # 2. First loop: Check XOR condition
    # Condition: (a[m] >= 0) XOR (a[i] >= 0)
    for i in range(n):
        # Check if signs are different (one non-negative, one negative)
        if (a[m] >= 0) != (a[i] >= 0):
            # Indices are 1-based: m+1 and i+1
            r.append(f"{m + 1} {i + 1}")

    # 3. Second block: Conditional additions
    if a[m] >= 0:
        # If a[m] is non-negative: add (i, i+1) for i = 1 to n-1
        for i in range(1, n):
            # Indices are 1-based: i and i+1
            r.append(f"{i} {i + 1}")
    else:
        # If a[m] is negative: add (i, i-1) for i = n down to 2
        # i runs from n down to 2 (inclusive)
        for i in range(n, 1, -1):
            # Indices are 1-based: i and i-1
            r.append(f"{i} {i - 1}")

    # Output results
    print(len(r))
    for item in r:
        print(item)

solve()
