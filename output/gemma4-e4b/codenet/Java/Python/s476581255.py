import sys

def bubble_sort(a):
    """
    Sorts the array a using bubble sort and returns the total number of swaps.
    The sorting is done in place.
    """
    n = len(a)
    swaps = 0
    
    while True:
        swapped = False
        # Iterate from the last element down to the second element
        for j in range(n - 1, 0, -1):
            if a[j] < a[j-1]:
                # Swap a[j] and a[j-1]
                a[j], a[j-1] = a[j-1], a[j]
                swaps += 1
                swapped = True
        
        # If no two elements were swapped by inner loop, then the array is sorted
        if not swapped:
            break
            
    return swaps

def main():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    try:
        # The first element is N
        n = int(input_data[0])
        
        # The remaining elements are the array A
        if n > 0:
            a = [int(x) for x in input_data[1:n+1]]
        else:
            a = []
    except ValueError:
        # Handle case where input might be malformed
        return

    # Perform the sort and count swaps
    count = bubble_sort(a)

    # Output the sorted array elements (space separated)
    print(*(a))
    
    # Output the total swap count
    print(count)

if __name__ == "__main__":
    main()