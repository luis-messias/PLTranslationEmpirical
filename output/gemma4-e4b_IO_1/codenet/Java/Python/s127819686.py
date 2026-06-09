import sys

def main():
    # Read the single line containing two space-separated integers
    try:
        # Read the line and split it
        line = sys.stdin.readline().strip()
        if not line:
            return
        
        # Assuming the input is always two numbers
        a, b = map(int, line.split())
    except ValueError:
        # Handles cases where splitting or conversion fails
        return

    # Calculate hb (integer division)
    hb = b // 2
    
    # Output the result
    print(a + hb)

if __name__ == "__main__":
    main()
