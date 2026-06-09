import math
import sys

def main():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    results = []
    i = 0
    
    # Process data in pairs (a, b)
    while i + 1 < len(data):
        try:
            a = int(data[i])
            b = int(data[i+1])
            
            sum_ab = a + b
            
            # Calculate digit = floor(log10(a+b)) + 1
            # Math.log10(x) is log base 10 of x
            digit = math.floor(math.log10(sum_ab)) + 1
            
            results.append(str(int(digit)))
            i += 2
        except ValueError:
            # Skip if conversion fails (should not happen with valid input)
            i += 1
            continue
        except IndexError:
            # Reached end of data unexpectedly
            break

    # Print results separated by newlines, matching the StringBuilder behavior
    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == "__main__":
    main()