import sys

try:
    # Read the line and split it into parts
    line = sys.stdin.readline().split()
    
    if len(line) == 2:
        h = int(line[0])
        a = int(line[1])
        
        num = 0
        # Loop while h is positive, performing subtraction and counting
        while h > 0:
            h = h - a
            num += 1
            
        print(num)
except:
    # Handle potential errors during reading or conversion
    pass