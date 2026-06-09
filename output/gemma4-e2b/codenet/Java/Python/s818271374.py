import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The remaining elements are the numbers a
    if len(data) < N + 1:
        # Handle case where not enough numbers are provided, though usually guaranteed in CP context
        return

    numbers = [int(x) for x in data[1:]]
    
    count1 = 0
    count2 = 0
    
    # Iterate through the N numbers read
    for a in numbers:
        if a % 4 == 0:
            count1 += 1
        elif a % 2 == 0 and (a // 2) % 2 == 1:
            count2 += 1
            
    # Check the conditions
    if count1 >= N / 2:
        print("Yes")
    elif ((N // 2 - count1) * 2 + N % 2) == count2:
        print("Yes")
    else:
        print("No")

solve()