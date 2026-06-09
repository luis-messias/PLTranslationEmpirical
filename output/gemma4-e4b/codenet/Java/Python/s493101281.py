import sys

def solve():
    # Reading all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where input might be empty or malformed
        return

    # The remaining elements are the list L
    if len(input_data) < n + 1:
        # Not enough elements provided
        return

    l = [int(x) for x in input_data[1:n+1]]

    # Sort the list
    l.sort()

    # Calculate the difference: l[n//2] - l[n//2 - 1]
    # Python integer division // handles the floor operation correctly.
    
    # Check if n >= 2 to prevent index out of bounds
    if n < 2:
        # If n is 0 or 1, the calculation is undefined based on the Java logic structure.
        # Assuming the input guarantees n >= 2 based on the original code structure.
        # If n=1, n//2 = 0, n//2 - 1 = -1 (IndexError).
        # We must assume n >= 2 for the original Java code to run without error.
        if n == 1:
            # If n=1, the Java code would try l.get(0) - l.get(-1), which is problematic.
            # Since the original Java code relies on n >= 2 for the indices to be valid,
            # we proceed assuming valid input size.
            pass
        else:
            return # No calculation possible

    # Calculate the required difference
    index_2 = n // 2
    index_1 = n // 2 - 1
    
    result = l[index_2] - l[index_1]

    # Print the result
    print(result)

if __name__ == "__main__":
    solve()