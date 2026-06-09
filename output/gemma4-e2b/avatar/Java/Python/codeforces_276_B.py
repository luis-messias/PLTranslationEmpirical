import sys

def solve():
    # Read the input string from standard input
    try:
        str_input = sys.stdin.readline().strip()
    except:
        str_input = ""

    if not str_input:
        # If input is empty, the result depends on the logic applied to an empty set.
        # If the input is empty, the map is empty, odd_count is 0. 0 <= 1 is True.
        print("First")
        return

    # 1. Count character frequencies
    map_counts = {}
    for char in str_input:
        map_counts[char] = map_counts.get(char, 0) + 1

    # 2. Count characters with odd frequencies
    odd_count = 0
    for count in map_counts.values():
        if count % 2 != 0:
            odd_count += 1

    # 3. Determine the output based on the condition: oddCount <= 1 || oddCount % 2 != 0
    if odd_count <= 1 or odd_count % 2 != 0:
        print("First")
    else:
        print("Second")

solve()