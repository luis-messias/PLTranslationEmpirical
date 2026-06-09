import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first token is N
    try:
        n = int(input_data[0])
    except IndexError:
        # Handle case where input might only