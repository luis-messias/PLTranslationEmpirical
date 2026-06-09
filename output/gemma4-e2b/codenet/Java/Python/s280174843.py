import sys

try:
    # Read all input and split by whitespace
    data = sys.stdin.read().split()
    
    if len(data) >= 3:
        # Convert the first three elements to integers
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        
        # Check the condition: a < b and b < c
        if a < b and b < c:
            print("Yes")
        else:
            print("No")
    
except ValueError:
    # Handle case where input elements are not valid integers
    pass