import sys

try:
    # Read the input line and split it into two integers a and b
    data = sys.stdin.read().split()
    if len(data) >= 2:
        a = int(data[0])
        b = int(data[1])
        
        if b % a == 0:
            print(a + b)
        else:
            print(b - a)
except:
    # Handle potential errors if input reading fails
    pass
