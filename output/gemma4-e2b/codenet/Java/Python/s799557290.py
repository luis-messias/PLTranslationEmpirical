import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # a and b are the first two integers
    try:
        a = int(data[0])
        b = int(data[1])
    except IndexError:
        return

    # Initialize arrays (size 100001, indices 0 to 100000)
    # ju tracks if a number has been marked AC
    ju = [False] * 100001
    # pe tracks the count of WA cases for a number
    pe = [0] * 100001
    
    data_idx = 2