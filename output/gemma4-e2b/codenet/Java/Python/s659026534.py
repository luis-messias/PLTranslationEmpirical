import sys

def main():
    # Read the integer n from standard input
    try:
        n = int(sys.stdin.read().strip())
    except:
        # Handle case where input might be empty or invalid, though typically not needed in strict translation context
        return

    # Calculate the sum of integers from 1 to n (1 + 2 + ... + n)
    # This is equivalent to the loop in the Java code: count += i for i in 1..n
    count = 0
    for i in range(1, n + 1):
        count += i
    
    # Alternatively, using the mathematical formula: count = n * (n + 1) // 2
    
    print(count)

if __name__ == "__main__":
    main()