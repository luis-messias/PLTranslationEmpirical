import sys

def func(A):
    a = list(A)
    min_val = 0
    
    # First pass: handle zeros and find the initial minimum non-zero element
    # We iterate and modify the list, which is tricky in Python if we rely on indices directly
    # A safer approach is to filter zeros first, or handle removal carefully.
    
    # The Java logic iterates over the list and modifies it based on the current minimum.
    
    i = 0
    while i < len(a):
        if a[i] == 0:
            a.pop(i)
            # If we remove an element, the next element shifts to index i.
            # We do not increment i here, as the new element at i needs to be checked.
            continue
        else:
            if min_val != 0:
                # Apply modulo operation
                a[i] %= min_val
                if a[i] == 1:
                    # Early exit condition found in Java, we must replicate this behavior.
                    # Since this is a helper function, we cannot call sys.exit directly.
                    # We need a mechanism to signal this result back, or rely on the main loop structure.
                    # Given the Java structure, this exit implies the entire process stops.
                    # In Python, we will rely on the caller handling the result if possible, 
                    # but since the Java code exits immediately, we must stop the recursion/iteration.
                    # For now, we will assume the main loop handles the exit condition based on the final result.
                    pass # We cannot exit here, we must let the loop continue or return the result.
            else:
                # Set min_val if it hasn't been set yet
                min_val = a[i]
        i += 1

    # Re-sort the list after modifications, as the Java code does this before returning.
    a.sort()
    return a

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    sc = iter(data)
    
    try:
        n = int(next(sc))
    except StopIteration:
        return

    a = []
    for _ in range(n):
        try:
            a.append(int(next(sc)))
        except StopIteration:
            break

    if n == 1:
        if a:
            print(a[0])
        return

    # The Java code reads N, then reads N elements.
    # If we read N elements successfully:
    
    # The Java code handles the case where the last element is 0 immediately after reading.
    # We need to ensure we read exactly N elements.
    
    if len(a) != n:
        # Handle case where input might be incomplete, though typically competitive programming inputs are guaranteed.
        return

    a.sort()

    if a[-1] == 0:
        print(0)
        return

    ans = 0
    
    # Iterative reduction loop
    while True:
        if len(a) == 1:
            ans = a[0]
            break
        
        # Apply the reduction function
        a = func(a)
        
        # Check for early exit condition based on the Java logic:
        # The Java func() exits if a[i] becomes 1. We must replicate this if possible.
        # Since func() cannot exit the main program, we check if the result of func() implies termination.
        # The Java code exits inside func() if a[i]