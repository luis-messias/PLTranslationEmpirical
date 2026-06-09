import sys

try:
    # Read all input and split it into integers
    data = sys.stdin.read().split()
    if len(data) >= 3:
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
        
        # Check the condition: a < b AND b < c AND a < c
        if a < b and b < c and a < c:
            print("Yes")
        else:
            print("No")
    # If input is insufficient, we do nothing or handle error based on context.
    
except Exception:
    # Handle case where input reading fails
    pass
