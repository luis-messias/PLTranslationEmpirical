import sys

def main():
    # Read input from stdin, expecting two space-separated integers
    try:
        # Read all input and split by whitespace
        data = sys.stdin.read().split()
        if len(data) >= 2:
            a = int(data[0])
            b = int(data[1])
            
            # Calculate hb using integer division
            hb = b // 2
            
            # Output the result
            print(a + hb)
    except:
        # Handle potential errors during reading/conversion
        pass

if __name__ == "__main__":
    main()
