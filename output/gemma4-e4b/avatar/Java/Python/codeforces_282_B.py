import sys

def solve():
    # Read all input data from stdin and split it into tokens
    try:
        data = sys.stdin.read().split()
    except:
        # Handle case where no input is provided
        print(-1)
        return

    if not data:
        # If input is empty, assume failure or handle based on specific constraints
        print(-1)
        return

    try:
        # The first element is n
        n = int(data[0])
    except ValueError:
        # If n cannot be read, exit
        print(-1)
        return

    # Check if enough data exists for n pairs (2*n elements after n)
    if len(data) < 1 + 2 * n:
        # Input is incomplete
        print(-1)
        return

    # Initialize variables
    s1 = 0
    s2 = 0
    result_chars = []
    flag = 0

    # Process the pairs (x, y)
    for i in range(n):
        # Indices for x and y in the data list
        data_index = 1 + 2 * i
        x = int(data[data_index])
        y = int(data[data_index + 1])

        temp1 = s1 + x
        temp2 = s2 + y

        # Condition 1: Try 'A'
        if abs(temp1 - s2) <= 500:
            s1 += x
            result_chars.append('A')
            continue

        # Condition 2: Try 'G'
        if abs(temp2 - s1) <= 500:
            s2 += y
            result_chars.append('G')
            continue

        # Failure
        flag = 1
        break

    # Output result
    if flag == 1:
        print(-1)
    else:
        print("".join(result_chars))