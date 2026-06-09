import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    n = int(data[0])
    
    # The remaining elements form the array of size 3*N
    # These are the elements read by sc.nextInt() in the Java code
    array = [int(x) for x in data[1:]]
    
    # Sort the array
    array.sort()
    
    # Calculate the sum based on the logic: sum elements at indices 3n-2, 3n-4, ..., 3n - 2n
    # In the Java code, array.length is 3*n.
    # head starts at 3*n - 2
    head = len(array) - 2
    res = 0
    
    # Loop n times
    for _ in range(n):
        res += array[head]
        head -= 2
        
    print(res)

solve()