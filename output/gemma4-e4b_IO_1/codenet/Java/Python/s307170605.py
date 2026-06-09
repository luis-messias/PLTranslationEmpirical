import sys

def main():
    # Read all space-separated tokens from standard input
    input_data = sys.stdin.read().split()
    
    # Iterate up to 5 times, or until input runs out
    for i in range(min(5, len(input_data))):
        try:
            input_val = int(input_data[i])
        except ValueError:
            # Stop if input is not a valid integer
            break
        
        if input_val == 0:
            print(i + 1)
            return

if __name__ == "__main__":
    main()
