import sys

try:
    # Read all input and split by whitespace to get the numbers
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        a = int(data[0])
        b = int(data[1])
        
        # Calculate c = a - b * 2
        c = a - b * 2
        
        # Ensure c is not negative
        if c < 0:
            c = 0
            
        # Print the result
        print(c)
        
except Exception:
    # Suppress exceptions as in the original Java code
    pass