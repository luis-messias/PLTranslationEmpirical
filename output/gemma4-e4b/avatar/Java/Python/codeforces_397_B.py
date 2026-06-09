import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is T, the number of test cases
    t = int(input_data[0])
    data_index = 1
    results = []

    for _ in range(t):
        # Read N, A, B for the current test case
        n = int(input_data[data_index])
        a = int(input_data[data_index+1])
        b = int(input_data[data_index+