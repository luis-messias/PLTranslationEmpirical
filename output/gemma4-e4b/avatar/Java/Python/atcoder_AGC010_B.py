import sys

def possible(N, A):
    """
    Checks if the given array A of size N satisfies the required condition.
    """
    # Calculate sum of A
    sum_a = sum(A)
    
    # Calculate NS = N * (N + 1) / 2
    # Using integer division // since N*(N+1) is always even
    NS = N * (N + 1) // 2
    
    # Check if sum is divisible by NS
    if sum_a % NS != 0:
        return False
    
    # Calculate K = sum / NS
    K = sum_a // NS
    
    # Loop through A
    for i in range(N):
        # Determine j: j is the index preceding i, wrapping around from 0 to N-1
        # j = (i - 1) mod N
        j = (i - 1 + N) % N
        
        # Calculate d = K - (A[i] - A[j])
        d = K - (A[i] - A[j])
        
        # Check conditions for d
        if d < 0 or d % N != 0:
            return False
            
    return True

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    N = int(input_data[0])
    
    # A are the remaining N elements
    A = [int(x) for x in input_data[1:N+1]]
    
    if possible(N, A):
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    solve()