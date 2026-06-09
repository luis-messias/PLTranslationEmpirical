import sys

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    results = []
    
    # Process tokens in pairs (a, b)
    # We iterate up to len(data) - 1, stepping by 2
    for i in range(0, len(data) - 1, 2):
        try:
            a = int(data[i])
            b = int(data[i+1])
        except ValueError:
            # Stop if input format is incorrect
            break
        
        s = a + b
        
        # Calculate the number of digits in the sum s.
        # This is equivalent to len(str(abs(s))) for non-negative sums, 
        # matching the behavior of log10(s) + 1 for s > 0.
        if s == 0:
            digit = 1
        else:
            digit = len(str(abs(s)))
            
        results.append(str(digit))

    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == "__main__":
    main()