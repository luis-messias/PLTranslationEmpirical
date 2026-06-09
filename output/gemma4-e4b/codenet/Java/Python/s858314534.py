import sys

def solve():
    # Read all inputs from standard input and split them into tokens
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        A = int(data[0])
        B = int(data[1])
        T = int(data[2])
    except Exception:
        # Handle case where input might be missing or malformed
        return

    # The Java code uses integer division (T / A)
    # In Python, we use // for integer division
    result = (T // A) * B
    
    # The log function simply prints the integer result
    print(result)

if __name__ == "__main__":
    solve()