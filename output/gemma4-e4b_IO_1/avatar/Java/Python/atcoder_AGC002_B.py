def solve():
    """
    The input is a sequence of lines, each representing a record.
    The goal is to count the total number of records.
    """
    # Read all lines from standard input
    import sys
    input_data = sys.stdin.readlines()

    # The number of records is simply the number of lines read.
    num_records = len(input_data)

    # Print the result
    print(num_records)

# Since the problem description implies reading all available input lines
# and the provided example structure suggests a simple count, we use the solve function.
solve()
