import sys

def solve():
    # Read all tokens from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        s = data[0]
        k = int(data[1])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    result = []

    for char in s:
        # Calculate the cost to change char to 'a'
        # Index of char: ord(char) - ord('a')
        # Cost: 26 - index
        
        if char == 'a':
            cost = 0
        else:
            index = ord(char) - ord('a')
            cost = 26 - index
        
        # Check condition: