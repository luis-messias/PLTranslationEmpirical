import sys

def solve():
    # Read all tokens from standard input
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_index = 0

    def get_next_int():
        nonlocal data_index
        if data_index < len(input_data):
            val = int(input_data[data_index])
            data_index += 1
            return val
        return None

    # Read N, A, B
    n = get_next_int()
    a = get_next_int()
    b = get_next_int()

    # Read list1 (A elements)
    list1 = []
    for _ in range(a):
        list1.append(get_next_int())

    # Read list2 (B elements) - Note: list2 is read but unused in the logic
    list2 = []
    for _ in range(b):
        list2.append(get_next_int())

    results = []
    # Iterate N times, checking for i+1 in list1
    for i in range(n):
        check_val = i + 1
        if check_val in list1:
            results.append(1)
        else:
            results.append(2)

    # Print results space-separated
    print(*(results))

solve()