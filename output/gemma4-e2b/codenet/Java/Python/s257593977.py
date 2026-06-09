import sys

try:
    # Read the integer from standard input
    n = int(sys.stdin.read().strip())
    BASE = 3
    
    # Calculate n raised to the power of BASE (n^3)
    result = n ** BASE
    
    # Print the result as an integer
    print(int(result))
except:
    # Handle case where input might be empty or invalid
    pass