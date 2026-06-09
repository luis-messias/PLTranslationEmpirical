import sys

def main():
    # Reading input from standard input
    try:
        # Read all three integers from standard input
        # Assuming the input is provided on separate lines or space-separated
        # For simplicity and matching the Java structure (reading three ints sequentially),
        # we'll read them as if they are provided one after another.
        
        # A common pattern for competitive programming style input in Python
        # is to read the line and split it, but since the Java code uses 
        # sc.nextInt() three times, we'll simulate reading three distinct inputs.
        
        # We use sys.stdin.read().split() to handle potential multi-line input
        data = sys.stdin.read().split()
        if len(data) < 3:
            return # Handle case where not enough input is provided

        x = int(data[0])
        y = int(data[1])
        z = int(data[2])
        
    except EOFError:
        return
    except ValueError:
        return

    # Outputting z, x, and y separated by spaces
    print(f"{z} {x} {y}")

if __name__ == "__main__":
    main()