import sys

try:
    # Read the integer input
    intA = int(sys.stdin.read().strip())
    
    # Calculate the cube and print the result
    # Math.pow(intA, 3) is equivalent to intA ** 3 in Python for integer powers
    result = intA ** 3
    print(result)
except:
    # Handle potential errors if input reading fails
    pass