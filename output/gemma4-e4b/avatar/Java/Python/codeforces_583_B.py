import sys

def solve():
    # Read all input tokens from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    data_ptr = 0
    
    while data_ptr < len(data):
        try:
            # Read N
            n