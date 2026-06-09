import sys
from collections import deque

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
        b = int(data[1])
    except IndexError:
        return

    # Initialize structures
    ans = [0] * n
    q = deque()
    data_ptr = 2

    for i in range(n):
        if data_ptr + 1 >= len(data):
            break