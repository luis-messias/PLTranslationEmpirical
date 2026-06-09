import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input reading
    n = int(data[0])
    if n == 0:
        return
        
    a = [int(x) for x in data[1:n+1]]

    cost1 = 0
    cost2 = 0
    current1 = 0
    current2 = 0
    
    dp1 = [0] * n
    dp2 = [0] * n
    
    i = 0
    j = n - 1
    
    # Core calculation loop: i increases, j decreases
    while i < n:
        # Pass 1 (Forward pass using a[i])
        cost1 += abs(a[i] - current1)
        current1 = a[i]
        dp1[i] = cost1
        
        # Pass 2 (Backward pass using a[j])
        cost2 += abs(a[j] - current2)
        current2 = a[j]
        dp2[j] = cost2
        
        i += 1
        j -= 1

    # Output loop
    for i in range(n):
        if i == 0:
            # System.out.println(dp2[i + 1] + Math.abs(a[1]));
            # Note: This assumes n >= 2 for dp2[1] and a[1] to be valid indices.
            if n > 1:
                print(dp2[1] + abs(a[1]))
            # If n=1, this branch is skipped or handled implicitly if we assume valid input context.
        elif i == n - 1:
            # System.out.println(dp1[i - 1] + Math.abs(a[
