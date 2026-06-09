import sys

def solve():
    # Read all tokens from standard input
    try:
        tokens = sys.stdin.read().split()
    except Exception:
        # Handle case where no input is provided
        tokens = []

    results = []
    token_index = 0
    
    while token_index < len(tokens):
        try:
            # Read c (integer)
            c = int(tokens[token_index])
            token_index += 1
            
            # Read mark (string)
            mark = tokens[token_index]
            token_index += 1
            
            # Read b (integer)
            b = int(tokens[token_index])
            token_index += 1
        except IndexError:
            # Ran out of tokens unexpectedly
            break

        if mark == "?":
            results.append(2000001)
            break
        elif mark == "+":
            results.append(c + b)
        elif mark == "-":
            results.append(c - b)
        elif mark == "*":
            results.append(c * b)
        elif mark == "/":
            # Integer division, matching Java behavior
            if b != 0:
                results.append(c // b)
            else:
                # Handle division by zero if necessary, though Java would throw an exception
                # Assuming valid input based on original code structure
                pass

    # Print results until the sentinel value is reached
    for result in results:
        if result == 2000001:
            break
        print(result)

if __name__ == "__main__":
    solve()