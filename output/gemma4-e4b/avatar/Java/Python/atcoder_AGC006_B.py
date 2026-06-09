import sys

def print_sequence(x, n):
    max_val = n * 2 - 1
    
    if x == 1 or x == max_val:
        print("No")
        return

    print("Yes")
    
    # Determine the range of numbers e: [x + n - 1, x + n + max_val - 2]
    start = x + n - 1
    end = x + n + max_val - 1 # Exclusive end bound for range()
    
    values = []
    for e in range(start, end):
        # Calculate (e % max_val + 1)
        value = (e % max_val) + 1
        values.append(str(value))
        
    # Join the values using the system's newline separator
    print("\n".join(values))

def main():
    # Read n and x from standard input
    try:
        # Assuming input format is two space-separated integers
        data = sys.stdin.read().split()
        if not data:
            return
        n = int(data[0])
        x = int(data[1])
    except EOFError:
        return
    except IndexError:
        # Handle case where not enough arguments are provided
        return

    print_sequence(x, n)

if __name__ == "__main__":
    main()