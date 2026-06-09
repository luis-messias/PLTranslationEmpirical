import sys

# We use sys.stdin.readline() to handle input reading robustly, 
# especially when simulating the sequential nature of the Java Scanner.
def solve():
    i = 0
    
    # Loop structure mimics for(i=1; i<=5; i++)
    for i in range(1, 6):
        try:
            # Read the next integer input
            line = sys.stdin.readline().strip()
            if not line:
                break
            n = int(line)
        except ValueError:
            # Handle case where input is not an integer
            break
        
        if n == 0:
            break
    
    print(i)

# Since the original Java code is a simple main function, 
# we structure the Python code to execute the logic directly.
solve()