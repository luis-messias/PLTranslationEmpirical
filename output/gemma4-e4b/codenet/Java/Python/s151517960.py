import sys
from collections import Counter

def main():
    # Read all input tokens from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        return

    # The numbers are the next N elements
    if len(input_data) < n + 1:
        return
        
    # Extract the N numbers
    numbers = [int(x) for x in input_data[1:n+1]]
    
    # Calculate frequencies using Counter
    counts = Counter(numbers)
    
    # Count how many distinct numbers appeared an odd number of times
    ans = 0
    for count in counts.values():
        if count % 2 != 0:
            ans += 1
            
    print(ans)

if __name__ == "__main__":
    main()