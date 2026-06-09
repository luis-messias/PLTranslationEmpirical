import sys

def solve():
    # Read all inputs from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element, M is the second
    n = int(data[0])
    m = int(data[1])

    # a needs to store m elements, indexed 1 to m. Size m+1.
    a = [0] * (m + 1)
    
    # Populate a[1] through a[m]
    # data[2] corresponds to a[1], data[3] to a[2], ..., data
