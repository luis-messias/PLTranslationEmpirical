import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first element is T
        t = int(data[0])
        data_index = 1
    except ValueError:
        return

    if t == 0:
        return

    # Read the array elements
    arr = []
    for _ in range(t):
        if data_index < len(data):
            arr.append(int(data[data_index]))
            data_index += 1
        else:
            # Input ended prematurely
            break
    
    if len(arr) != t:
        return

    prevWinner = 0