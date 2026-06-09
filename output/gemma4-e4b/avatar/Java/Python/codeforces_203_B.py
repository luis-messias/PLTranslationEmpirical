import sys

def solve():
    # Read all input data and split it into tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, M is the second.
    N = int(data[0])
    M