import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        print("0 0")
        return

    try:
        # The first element is the length (len)
        len_a = int(input_data[0])
        # The remaining elements are the array a
        a = [int(x) for x in input_data[1:len_a + 1]]
