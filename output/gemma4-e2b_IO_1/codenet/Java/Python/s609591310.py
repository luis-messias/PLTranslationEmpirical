import sys

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element
    n = int(input_data[0])
    
    # The list elements follow
    if len(input_data) < n + 1:
        # Not enough data for N and the list elements
        return
        
    list_data = [int(x) for x in input_data[1:n+1]]
    
    # Initialize frequency lists (size 100000)
    MAX_SIZE = 100000
    numlist1 = [0] * MAX_SIZE
    numlist2 = [0] * MAX_SIZE

    # Populate frequency lists based on pairs (list[i], list[i+1])
    # list_data corresponds to the input list
    for i in range(0, n, 2):
        if i + 1 < n:
            val1 = list_data[i]
            val2 = list_data[i+1]
            
            # Java uses list[i]-1 and list[i+1]-1 as indices.
            # We must ensure the values are positive before subtracting 1.
            if val1 >= 1 and val1 <= MAX_SIZE:
                numlist1[val1 - 1] += 1
            if val2 >= 1 and val2 <= MAX_SIZE:
                numlist2[val2 - 1] += 1

    # Find the top two elements and their indices for numlist1
    max11 = 0  # Largest value
    max12 = 0  # Second largest value
    val1 = -1  # Index of the largest value (0-based index)
    
    # Find the top two elements and their indices for numlist2
    max21 = 0  # Largest value
    max22 = 0  # Second largest value
