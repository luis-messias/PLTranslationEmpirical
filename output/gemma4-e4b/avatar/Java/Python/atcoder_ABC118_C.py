import sys

def func(A):
    """
    Implements the logic of the Java func method.
    Modifies the list A in place (conceptually) and returns the result.
    """
    a = list(A)  # Work on a copy
    min_val = 0
    
    i = 0
    while i < len(a):
        current_val = a[i]
        
        if current_val == 0:
            # Remove the element and do not increment i
            a.pop(i)
            continue
        
        if min_val != 0:
            # Update the value: a[i] = a[i] % min_val
            new_val = current_val % min_val
            a[i] = new_val
            
            # Check for early exit condition
            if new_val == 1:
                print(1)
                sys.exit(0)
        else:
            # First non-zero element found
            min_val = current_val
        
        i += 1
        
    # Sort the resulting list
    a.sort()
    return a

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is N, the rest are the array elements
    try:
        n = int(input_data[0])
        if n == 0:
            print(0)
            return
            
        a = [int(x) for x in input_data[1:n+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    # Edge Case: n=1
    if n == 1:
        print(a[0])
        return

    # Initial sort
    a.sort()

    # Edge Case: Max element is 0
    if a[-1] == 0:
        print(0)
        return

    # Main loop
    current_a = a
    while len(current_a) > 1:
        current_a = func(current_a)
    
    # Output the final result
    print(current_a[0])

if __name__ == "__main__":
    solve()