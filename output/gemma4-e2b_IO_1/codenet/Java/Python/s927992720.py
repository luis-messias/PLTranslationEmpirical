import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    i = 0
    while i < len(data):
        try:
            # Read a, op, b
            if i + 2 >= len(data):
                break
                
            a = int(data[i])
            op = data[i+1]
            b = int(data[i+2])
            
            if op == "?":
                break
            
            if op == "+":
                print(a + b)
            elif op == "-":
                print(a - b)
            elif op == "*":
                print(a * b)
            elif op == "/":
                # Java integer division behavior (a/b) is equivalent to Python's // for positive integers
                print(a // b)
            
            i += 3
        except ValueError:
            # Skip if conversion fails (shouldn't happen with the provided input format)
            i += 1
            continue
        except IndexError:
            # Ran out of data unexpectedly
            break

solve()
