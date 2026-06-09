import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if len(data) >= 2:
        try:
            # The Java code reads two integers: a and b
            a = int(data[0])
            b = int(data[1])
            
            # Calculate Math.max(0, a - 2*b)
            result = max(0, a - 2 * b)
            print(result)
        except ValueError:
            # Handle case where input is not convertible to integer
            pass

if __name__ == "__main__":
    # In a typical competitive programming environment, we read from stdin directly.
    # If running interactively, we might need to simulate input reading if the environment
    # doesn't provide it automatically.
    # For this specific problem structure, we assume the input (12 4) is provided.
    # If the input is provided as a single line "12 4", the logic above handles it.
    pass
