import sys

def solve():
    # Read all input data and take the first 10 integers
    data = sys.stdin.read().split()
    if not data:
        return
    
    Num = [int(x) for x in data[:10]]
    
    # Bubble Sort implementation
    n = len(Num)
    for i in range(n - 1):
        for j in range(n - 1 - i):
            # If the element is greater than the next element, swap them
            if Num[j] > Num[j+1]:
                Num[j], Num[j+1] = Num[j+1], Num[j]
    
    # Output the first three elements
    print(Num[0])
    print(Num[1])
    print(Num[2])

solve()