import sys

def main():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # The first token is N
        n = int(data[0])
        
        # The remaining tokens are the N numbers to be added to the set
        if len(data) > 1:
            numbers = [int(x) for x in data[1:]]
            
            # Create the set from the numbers
            result_set = set(numbers)
            
            # Print the size of the set
            print(len(result_set))
        else:
            # If N is read but no numbers follow (N=0 case, or input error)
            print(0)
            
    except ValueError:
        # Handle case where input tokens are not valid integers
        pass

if __name__ == "__main__":
    main()