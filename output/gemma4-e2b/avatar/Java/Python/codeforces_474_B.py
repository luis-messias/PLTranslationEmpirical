import sys

def fun(arr, q, n, m):
    res = 0
    i = 0
    j = n
    while i <= j:
        md = i + (j - i) // 2
        if arr[md] == q:
            return md
        elif arr[md] > q:
            res = md
            j = md - 1
        else:
            i = md + 1
    return res

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # Input parsing based on the Java structure
    
    # N is the first element
    n = int(data[0])
    
    # arr[0] is the second element
    arr = [0] * n
    arr[0] = int(data[1])
    
    # Read the remaining n-1 elements for arr
    # data index starts at 2 for the next element
    for i in range(1, n):
        # data index is 2 + i
        arr[i] = int(data[2 + i])
        
    # M is the next element
    m