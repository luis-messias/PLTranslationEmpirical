import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first number is N
    n = int(data[0])
    
    if n == 0:
        print(0)
        return

    # The remaining numbers are the array elements
    arr = [int(x) for x in data[1:]]
    
    # Calculate the result based on the Java logic: |a_0| + sum(|a_i - a_{i-1}|)
    
    # Initialize answer with |arr[0]|
    answer = abs(arr[0])
    
    # Add the sum of absolute differences between adjacent elements
    for i in range(1, n):
        answer += abs(arr[i] - arr[i-1])
        
    print