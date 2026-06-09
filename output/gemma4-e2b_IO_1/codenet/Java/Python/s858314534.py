import sys

def main():
    # Read input from stdin
    try:
        # Read all numbers from the input stream
        data = sys.stdin.read().split()
        
        if len(data) >= 3:
            A = int(data[0])
            B = int(data[1])
            T = int(data[2])
            
            # Calculate (T / A) * B. Java integer division (T / A) is equivalent to Python's //
            result = (T // A) * B
            
            # Print the result
            print(result)
            
    except Exception:
        # Handle potential errors during reading or conversion
        pass

if __name__ == "__main__":
    main()
