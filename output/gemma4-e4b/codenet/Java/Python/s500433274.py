import sys

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    # Process pairs of numbers
    i = 0
    while i < len(data) - 1:
        try:
            # Python integers handle arbitrary precision, replacing BigInteger
            a = int(data[i])
            b = int(data[i+1])
            
            # Determine relationship based on comparison
            if a > b:
                print("GREATER")
            elif b > a:
                print("LESS")
            else:
                print("EQUAL")
            
            i += 2
        except IndexError:
            # Stop if we run out of pairs
            break

if __name__ == "__main__":
    main()