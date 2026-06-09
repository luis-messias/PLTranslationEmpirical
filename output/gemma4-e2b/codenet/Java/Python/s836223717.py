import sys

def solve():
    # Read input n
    try:
        n = int(sys.stdin.read().strip())
    except:
        return

    if n < 0:
        return

    # Initialize the sequence array (equivalent to long[] ryuka)
    ryuka = [0] * (n + 1)
    
    # Set initial values
    if n >= 0:
        ryuka[0] = 2
    if n >= 1:
        ryuka[1] = 1
    
    # Calculate the sequence using the recurrence relation
    for i in range(2, n + 1):
        ryuka[i] = ryuka[i - 1] + ryuka[i - 2]
        
    # Print the result
    if n >= 0:
        print(ryuka[n])

solve()