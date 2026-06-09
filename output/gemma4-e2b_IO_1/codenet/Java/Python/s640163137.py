import sys

def solve():
    # Read input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where input might be malformed or empty
        return

    # The rest of the elements are the array a
    if len(input_data) < n + 1:
        return
        
    a = [int(x) for x in input_data[1:n+1]]

    # Core logic: Selection sort with swap counting
    swap_count = 0
    
    # We operate on the array 'a' directly
    for i in range(n):
        # Find the index of the minimum element in a[i...n-1]
        mini = i
        for j in range(i + 1, n):
            if a[j] < a[mini]:
                mini = j
        
        # If the minimum element is not already at position i, swap it
        if mini != i:
            # Perform the swap
            a[i], a[mini] = a[mini], a[i]
            swap_count += 1

    # Output the results
    # Print the sorted array elements separated by spaces
    print(*(a))
    # Print the swap count on a new line
    print(swap_count)

solve()
