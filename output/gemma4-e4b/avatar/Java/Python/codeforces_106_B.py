import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        N = int(data[0])
    except IndexError:
        # Handle case where input might be empty or malformed
        return

    # Parse the N x 4 matrix
    vec = []
    data_index = 1
    
    if len(data) < 1 + N * 4:
        # Not enough data provided
        return

    for i in range(N):
        row = [int(data[data_index]), 
               int(data[data_index+1]), 
               int(data[data_index+2]), 
               int(data[data_index+3])]
        vec.append(row)
        data_index += 4

    # Logic translation
    ans = 500
    ansprice = 20000
    
    for i in range(N):
        # fl =