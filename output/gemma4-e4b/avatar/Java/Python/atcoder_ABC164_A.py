import sys

def solve():
    # Read all input lines and take the first one, mimicking the Java logic
    input_data = sys.stdin.read().strip()
    
    if not input_data:
        return

    try:
        # Split the first line by spaces
        numlist = input_data.split()
        
        # Assuming exactly two numbers are provided
        sheep = int(numlist[0])
        wolve = int(numlist[1])
        
        if wolve >= sheep:
            print("unsafe")
        else:
            print("safe")
    except IndexError:
        # Handle case where not enough numbers are provided
        pass
    except ValueError:
        # Handle case where conversion to int fails
        pass

solve()