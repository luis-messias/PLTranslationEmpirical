import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # arr contains the next N elements
    arr = [int(x) for x in data[1:n+1]]

    if n == 0:
        print(0)
        print("")
        return

    # Calculate the total sum
    total_sum = sum(arr)
    
    count = 0
    indices = []

    # Handle the case where n=1 separately to avoid division by zero
    if n == 1:
        # If n=1, n-1=0. The original Java code would fail here.
        # Since the condition relies on division by n-1, we assume n >= 2 
        # or that the condition is vacuously false/undefined for n=1.
        # Based on the structure, if n=1, no indices should be counted.
        pass
    else:
        divisor = n - 1
        for i in range(n):
            # Check the condition: 
            # 1. (sum - arr[i]) % (n - 1) == 0
            # 2. (sum - arr[i]) / (n - 1) == arr[i]
            
            numerator = total_sum - arr[i]
            
            # Check divisibility
            if numerator % divisor == 0:
                # Calculate quotient using integer division
                quotient = numerator // divisor
                
                # Check equality
                if quotient == arr[i]:
                    count += 1
                    indices.append(str(i + 1))

    print(count)
    print(" ".join(indices))

solve()