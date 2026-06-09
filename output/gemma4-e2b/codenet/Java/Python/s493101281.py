import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where input might be empty or malformed
        return

    if n == 0:
        return

    # The remaining elements are the list L
    if len(data) < n + 1:
        # Not enough elements provided
        return
        
    l = []
    try:
        for i in range(1, n + 1):
            l.append(int(data[i]))
    except ValueError:
        # Handle case where subsequent elements are not integers
        return

    # Sort the list
    l.sort()

    # Calculate the result: l[n/2] - l[n/2 - 1]
    # Since Python uses floor division for //, n/2 in Java integer context 
    # corresponds to n // 2 in Python for integer division.
    # The Java code uses n/2, which results in integer division if n is an int.
    
    # Note: In Java, n=4, n/2=2. l.get(2) - l.get(1).
    # In Python, we use integer division //
    
    # If n is the length of the list, the indices are:
    # Middle element index: n // 2
    # Element before middle: (n // 2) - 1
    
    # Example: n=5. Indices 0, 1, 2, 3, 4. Middle is index 2. 
    # l[2] - l[1]. (5//2 - 1) = 2 - 1 = 1. Wait, this is wrong.
    # If n=5, n/2 = 2. We want l[2] - l[1].
    # If n=4, n/2 = 2. We want l[2] - l[1].
    
    # The Java code uses n/2 and n/2 - 1.
    # If n=5: l.get(2) - l.get(1).
    # If n=4: l.get(2) - l.get(1).
    
    # In Python:
    # index_high = n // 2
    # index_low = index_high - 1
    
    # Let's check the Java calculation: l.get(n/2) - l.get(n/2-1)
    # If n=5, n/2=2. l.get(2) - l.get(1). Correct.
    # If n=4, n/2=2. l.get(2) - l.get(1). Correct.
    
    result = l[n // 2] - l[n // 2 - 1]

    print(result)

solve()