import sys

def solve():
    # Read all tokens from standard input
    tokens = sys.stdin.read().split()
    
    if not tokens:
        return

    # Process tokens in pairs (a, b)
    i = 0
    while i + 1 < len(tokens):
        try:
            a = int(tokens[i])
            b = int(tokens[i+1])
            
            # The logic derived from the Java code is a simple comparison of a and b
            if a > b:
                print("GREATER")
            elif b > a:
                print("LESS")
            else:
                print("EQUAL")
            
            i += 2
        except ValueError:
            # Skip if conversion fails (shouldn't happen if input adheres to BigInteger format)
            i += 1
            continue

solve()