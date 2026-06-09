import sys

def print_island(n, count):
    a = (n + 1) // 2
    b = n // 2
    max_val = a * a + b * b
    
    if count > max_val:
        print("NO")
        return
    
    print("YES")
    
    current_count = count
    
    for i in range(n):
        row = []
        for j in range(n):
            # Check the condition: (i + j) % 2 == 0 AND current_count > 0
            if (i + j) % 2 == 0 and current_count > 0:
                row.append('L')
                current_count -= 1
            else:
                row.append('S')
        print("".join(row))

def main():
    # Read all input data from stdin
    input_data = sys.stdin.read().split()
    
    if len(input_data) < 2:
        # Handle case where input might be missing
        return

    try:
        n = int(input_data[0])
        count = int(input_data[1])
        print_island(n, count)
    except ValueError:
        # Handle non-integer input
        pass

if __name__ == "__main__":
    main()