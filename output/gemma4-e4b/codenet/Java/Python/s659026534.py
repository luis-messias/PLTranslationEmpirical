import sys

def main():
    try:
        # Read the integer N from standard input
        # We use sys.stdin.read().strip() to handle potential input variations
        input_data = sys.stdin.read().strip()
        if not input_data:
            return

        n = int(input_data)
    except EOFError:
        return
    except ValueError:
        return

    # Calculate the sum of integers from 1 to N
    # The original Java code calculates the sum iteratively: count += i
    # Mathematically, this is the sum of an arithmetic series: N * (N + 1) / 2
    
    # Using the formula (more efficient)
    count = n * (n + 1) // 2
    
    # Alternatively, using a loop (mimicking the original logic):
    # count = 0
    # for i in range(1, n + 1):
    #     count += i

    print(count)

if __name__ == "__main__":
    main()