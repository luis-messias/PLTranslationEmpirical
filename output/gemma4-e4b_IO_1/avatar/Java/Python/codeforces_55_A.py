import sys

def solve():
    # Read N from standard input
    try:
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        N = int(input_data)
    except EOFError:
        return
    except ValueError:
        return

    # Initialize array A of size N
    A = [0] * N
    
    # Variables initialization
    i = 0  # Current index accumulator
    k = 0  # Loop counter (k goes from 0 up to N)
    
    # Loop while k <= N
    while k <= N:
        # i += k
        i += k
        
        # i = i % N (Equivalent to the Java modulo logic)
        i = i % N
        
        # ++ A[i]
        A[i] += 1
        
        # ++ k
        k += 1
        
    # Check if all elements are non-zero
    if all(count > 0 for count in A):
        print("YES")
    else:
        print("NO")

solve()
