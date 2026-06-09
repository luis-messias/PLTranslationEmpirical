import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is n
    n = int(data[0])
    
    # The next 3*n elements are the array data
    # data[1] to data[3*n] inclusive
    array = [int(x) for x in data[1:3*n + 1]]
    
    # Sort the array
    array.sort()
    
    # Calculate the sum
    head = len(array) - 2
    res = 0
    
    for _ in range(n):
        res += array[head]
        head -= 2
        
    print(res)

solve()