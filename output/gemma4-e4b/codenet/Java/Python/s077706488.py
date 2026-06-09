import sys

def solve():
    # Read all inputs from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    N = int(data[0])
    # X is the second element
    X = int(data[1])
    
    # m elements start from index 2
    m = [int(data[i]) for i in range(2, 2 + N)]

    if N == 0:
        # If N is 0, the logic might be undefined, but we follow the structure.
        # Since the original code assumes N >= 1 for m[0] access, we handle the calculation based on the assumption that N >= 1 if inputs are provided.
        # If N=0, we just print N (0) as no other calculation can proceed safely.
        print(0)
        return

    # Initialization based on m[0]
    X -= m[0]
    min_val = m[0]

    # Loop from i=1 to N-1
    for i in range(1, N):
        m_i = m[i]
        X -= m_i
        if m_i < min_val:
            min_val = m_i

    # Calculate N + X // min_val (using integer division //)
    # We assume min_val is non-zero based on typical constraints, matching the behavior of the original Java code.
    if min_val == 0:
        # Handle division by zero if necessary, though the original Java code would crash here too.
        # For translation purposes, we proceed with the calculation structure.
        # If the problem guarantees min_val != 0, this check is unnecessary.
        pass 
        
    result = N + X // min_val
    print(result)

solve()