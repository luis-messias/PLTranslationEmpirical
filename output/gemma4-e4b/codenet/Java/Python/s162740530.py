import sys

def solve():
    # Read all inputs from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, M is the second
    n = int(data[0])
    m = int(data[1])

    # a needs to store m elements, indexed 1 to m, mimicking Java's array usage.
    # We create a list of size m + 1 and fill it.
    a = [0] *