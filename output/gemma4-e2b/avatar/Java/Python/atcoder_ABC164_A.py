import sys

try:
    # Read all input lines
    input_lines = sys.stdin.read().splitlines()
    
    if input_lines:
        # Process the first line
        line = input_lines[0].strip()
        if line:
            numlist = line.split()
            if len(numlist) >= 2:
                Sheep = int(numlist[0])
                Wolve = int(numlist[1])
                
                if Wolve >= Sheep:
                    print("unsafe")
                else:
                    print("safe")
except Exception:
    # Handle potential errors during reading or conversion
    pass