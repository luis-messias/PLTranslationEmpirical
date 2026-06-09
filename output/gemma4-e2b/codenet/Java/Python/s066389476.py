import sys

def solve():
    try:
        # Read the input line from standard input
        line = sys.stdin.readline().strip()
        
        if len(line) >= 3:
            # Convert the input string into a list of characters (equivalent to char array)
            a = list(line)
            
            # Check the condition: a[0] == a[1] || a[1] == a[2] || a[2] == a[0]
            if a[0] == a[1] or a[1] == a[2] or a[2] == a[0]:
                print("No")
            else:
                print("Yes")
        # If input is less than 3 characters, the condition cannot be fully evaluated 
        # based on the Java logic, but we handle the case where input exists.
        
    except Exception:
        # Handle potential errors during input reading
        pass

solve()