import sys

def solve():
    # Read all input data and take the first 10 integers
    data = sys.stdin.read().split()
    if not data:
        return
    
    Num = [int(x) for x in data[:10]]
    
    # Bubble Sort implementation (Sorting in DESCENDING order, matching Java logic)
    n = len(Num)
    for i in range(n - 1):
        for j in range(n - 1
