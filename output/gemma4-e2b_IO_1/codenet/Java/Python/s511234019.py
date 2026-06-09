import sys

try:
    # Read all input and split by whitespace
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        a = int(data[0])
        b = int(data[1])
        
        # Check the condition: if a is even OR b is even
        if a % 2 == 0 or b % 2 == 0:
            print("No")
        else:
            print("Yes")
except:
    # Handle case where input might be malformed or empty
    pass
