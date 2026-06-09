import sys

def solve():
    # Read all input data from stdin and split into tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element, K is the second
    N = int(input_data[0])
    K = int(input_data[1])
    
    # The remaining N elements form the array A
    # input_data[2] to input_data[2+N-1]
    A = [int(x) for x in input_data[2:2+N]]
    
    # Sort the array A
    A.sort()
    
    # Calculate the sum of the first K elements
    # Python slicing A[:K] gets the first K elements
    ans = sum(A[:K])
    
    # Output the result
    print(ans)

if __name__ == "__main__":
    solve()