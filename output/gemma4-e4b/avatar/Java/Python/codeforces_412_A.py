import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n, k, and a are read sequentially
    try:
        n = int(data[0])
        k = int(data[1])
        a = data[2]
    except IndexError:
        # Handle case where not enough input is provided
        return

    # Logic Block 1: Movement based on k vs n/2
    # Note: In Java, n/2 performs integer division if n is an int. 
    # We use n // 2 in Python for equivalent integer division.
    if k > n // 2:
        while k < n:
            print("RIGHT")
            k += 1
    else:
        while k > 1:
            print("LEFT")
            k -= 1

    # Logic Block 2: Printing characters
    if k == 1:
        # Forward iteration (i = 0 to length - 1)
        for i in range(len(a)):
            print(f"PRINT {a[i]}")
            if (i + 1) < len(a):
                print("RIGHT")
    else:
        # Backward iteration (i = length - 1 down to 0)
        for i in range(len(a) - 1, -1, -1):
            print(f"PRINT {a[i]}")
            if (i - 1) >= 0:
                print("LEFT")

solve()