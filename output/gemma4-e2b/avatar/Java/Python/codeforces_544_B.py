import sys

def printIsland(n, count):
    a = (n + 1) // 2
    b = n // 2
    max_val = a * a + b * b
    
    if count > max_val:
        print("NO")
        return
    
    print("YES")
    
    for i in range(n):
        sb = []
        for j in range(n):
            if (i + j) % 2 == 0 and count > 0:
                sb.append('L')
                count -= 1
            else:
                sb.append('S')
        print("".join(sb))

# Read input from stdin
try:
    # Read n and count
    input_data = sys.stdin.read().split()
    if len(input_data) >= 2:
        n = int(input_data[0])
        count = int(input_data[1])
        printIsland(n, count)
except:
    # Handle case where input might be empty or invalid
    pass