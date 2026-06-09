import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0

    # 1. Read n
    n = int(data[data_ptr])
    data_ptr += 1

    # 2. Read levels
    levels = int(data[data_ptr])
    data_ptr += 1

    # 3. Read arr (levels elements)
    arr = [int(data[data_ptr + i]) for i in range(levels)]
    data_ptr += levels

    # 4. Read level2
    level2 = int(data[data_ptr])
    data_ptr += 1

    # 5. Read the remaining level2 elements for arr2
    # arr2 consists of the initial 'levels' elements followed by 'level2' elements.
    arr2 = arr + [int(data[data_ptr + i]) for i in range(level2)]
    # data_ptr += level2 # Not strictly necessary as we are done reading

    # 6. Initialize arr3 (1 to n)
    arr3 = list(range(1, n + 1))

    # 7. Counting Matches
    count = 0
    
    # Optimization: Convert arr2 to a set for O(1) average time complexity lookup
    # This preserves the logic of checking existence.
    arr2_set = set(arr2)

    # Iterate through arr3 (elements 1 through