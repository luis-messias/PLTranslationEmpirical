import sys

try:
    # Read the line from standard input
    line = sys.stdin.readline().strip()
    if not line:
        # Handle empty input
        sys.exit()
        
    # Split the line into parts and convert to integers
    list_nums = line.split()
    if len(list_nums) < 3:
        # Handle case where input is insufficient
        sys.exit()
        
    x = int(list_nums[0])
    a = int(list_nums[1])
    y = int(list_nums[2])
    
    h = "NO"
    
    # Check the first condition: x == 5 | x == 7 | a == 5 | a == 7 | y == 5 | y == 7
    condition1 = (x == 5 or x == 7 or a == 5 or a == 7 or y == 5 or y == 7)
    
    if condition1:
        # Check the second condition: x + y + a == 17
        if x + y + a == 17:
            h = "YES"
            
    print(h)

except Exception:
    # In case of any error during reading or conversion
    pass