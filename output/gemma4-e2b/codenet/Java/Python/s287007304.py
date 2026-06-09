import sys

try:
    # Read all input, split by whitespace, and attempt to parse the first two elements
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        a = int(data[0])
        b = int(data[1])
        
        if b % a == 0:
            print(a + b)
        else:
            print(b - a)
except:
    # Handle potential errors during input reading or conversion
    pass