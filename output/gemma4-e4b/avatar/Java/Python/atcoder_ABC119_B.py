import sys

def solve(x, u):
    """
    Calculates the weighted sum based on currency type.
    """
    total = 0.0
    for i in range(len(x)):
        # Determine multiplier: 1 if "JPY", 380000 otherwise
        multiplier = 1.0 if u[i] == "JPY" else 380000.0
        total += x[i] * multiplier
    return total

def main():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    try:
        N = int(data[0])
    except ValueError:
        return

    x = []
    u = []
    
    # Data tokens start from index 1. We expect N pairs (x_i, u_i).
    # x_i is at index 1 + 2*i
    # u_i is at index 2 + 2*i
    
    for i in range(N):
        try:
            # Read double (float)
            x.append(float(data[1 + 2 * i]))
            # Read string
            u.append(data[2 + 2 * i])
        except IndexError:
            # Handle case where input might be incomplete
            break
            
    result = solve(x, u)
    print(result)

if __name__ == "__main__":
    main()