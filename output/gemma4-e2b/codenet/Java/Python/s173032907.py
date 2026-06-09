import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input reading based on Java's Scanner behavior
    n = int(data[0])
    a = [int(x) for x in data[1:n+1]]

    cost1 = 0
    cost2 = 0
    current1 = 0
    current2 = 0
    
    dp1 = [0] * n
    dp2 = [0] * n

    # The loop structure mimics the Java code: i increases, j decreases
    # i goes from 0 to n-1, j goes from n-1 down to 0
    for i in range(n):
        j = n - 1 - i
        
        # Calculation for cost1 (forward pass using a[i])
        # Note: The Java loop structure is slightly different: for (int i = 0, j = n - 1; i < n; i++, j--)
        # Let's stick to the structure implied by the Java loop indices i and j moving together.
        
        # Replicating the Java loop structure exactly:
        # i starts at 0, j starts at n-1. Loop runs while i < n. i++, j-- inside.
        pass # We will rewrite the loop below to match the simultaneous update logic

    cost1 = 0
    cost2 = 0
    current1 = 0
    current2 = 0
    dp1 = [0] * n
    dp2 = [0] * n
    
    i = 0
    j = n - 1
    
    while i < n:
        # Cost1 calculation (forward pass)
        cost1 += abs(a[i] - current1)
        current1 = a[i]
        dp1[i] = cost1
        
        # Cost2 calculation (backward pass)
        cost2 += abs(a[j] - current2)
        current2 = a[j]
        dp2[j] = cost2
        
        i += 1
        j -= 1

    # Output loop
    for i in range(n):
        if i == 0:
            # System.out.println(dp2[i + 1] + Math.abs(a[1]));
            # Since i=0, i+1=1. We need to handle the case where n=1 carefully, but assuming n>=2 based on the logic.
            if n > 1:
                print(dp2[1] + abs(a[1]))
            else:
                # If n=1, this branch is problematic if we strictly follow the Java logic, 
                # but the Java code accesses a[1] which would crash if n=1. 
                # Assuming standard competitive programming context where n is large enough for the logic to make sense.
                pass 
        elif i == n - 1:
            # System.out.println(dp1[i - 1] + Math.abs(a[i - 1]));
            print(dp1[i - 1] + abs(a[i - 1]))
        else:
            # System.out.println(dp1[i - 1] + dp2[i + 1] + Math.abs(a[i - 1] - a[i + 1]));
            print(dp1[i - 1] + dp