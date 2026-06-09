import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # The first element is N
    n = int(data[0])
    
    # The remaining elements are the list values
    list_data = [int(x) for x in data[1:]]
    
    # Ensure we have exactly N elements if N was read correctly
    if len(list_data) != n:
        # Handle case where input might be malformed or incomplete, though typically competitive programming assumes correct input structure.
        # For this translation, we proceed with what we read.
        pass

    # Initialize frequency lists (size 100000)
    MAX_SIZE = 100000
    numlist1 = [0] * MAX_SIZE
    numlist2 = [0] * MAX_SIZE

    # Populate frequency lists based on pairs
    # list_data contains the N elements read after N itself.
    # We iterate over the list_data in steps of 2.
    for i in range(0, n, 2):
        # list_data[i] corresponds to list[i] in Java
        # list_data[i+1] corresponds to list[i+1] in Java
        
        # Java uses list[i]-1 and list[i+1]-1 as indices.
        # We must ensure list_data[i] and list_data[i+1] are valid indices (>= 1)
        
        if i < n and i + 1 < n:
            val1 = list_data[i]
            val2 = list_data[i+1]
            
            # Check bounds before accessing, although the Java code assumes list[i] >= 1
            if 1 <= val1 <= MAX_SIZE:
                numlist1[val1 - 1] += 1
            if 1 <= val2 <= MAX_SIZE:
                numlist2[val2 - 1] += 1

    # Find the top two elements and their indices for numlist1
    max11 = 0  # Largest value
    max12 = 0  # Second largest value
    val1 = -1  # Index of the largest value
    
    # Find the top two elements and their indices for numlist2
    max21 = 0  # Largest value
    max22 = 0  # Second largest value
    val2 = -1  # Index of