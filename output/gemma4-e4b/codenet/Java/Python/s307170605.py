import sys

def main():
    # We simulate reading 5 inputs sequentially.
    for i in range(5):
        try:
            # Read the next integer from standard input
            # Using sys.stdin.readline() is robust for reading sequential inputs
            line = sys.stdin.readline()
            if not line:
                break
            
            input_val = int(line.strip())
        except ValueError:
            # Stop if input is not a valid integer
            break
        
        if input_val == 0:
            print(i + 1)
            break

if __name__ == "__main__":
    main()