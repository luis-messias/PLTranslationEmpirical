import sys

def solve():
    # Read all input data from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    n = int(input_data[0])
    m = int(input_data[1])

    a = []

    if n % m == 0:
        # Case 1: Divisible
        a = [n // m] * m
    else:
        # Case 2: Not divisible
        sub = n // m
        a = [sub] * m
        
        remainder = n % m
        
        # Increment the first 'remainder' elements
        for i in range(remainder):
            a[i] += 1

    # Output the elements separated by spaces
    print(*(a))

solve()
