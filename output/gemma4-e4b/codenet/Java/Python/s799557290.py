import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    # a: number of problems (limit for final check)
    # b: number of test cases
    try:
        a = int(data[0])
        b = int(data[1])
    except IndexError:
        # Handle case where only a or b might be provided
        return

    # Initialize arrays/lists. Size 100001 based on Java implementation.
    MAX_SIZE = 100001
    ju = [False] * MAX_SIZE  # Tracks if problem is AC'd
    pe = [0] * MAX_SIZE     # Tracks WA count for each problem

    data_ptr = 2
    
    # Process b test cases
    for _ in range(b):
        if data_ptr >= len(data):
            break
            
        try:
            # n is the problem index (1-based)
            n = int(data[data_ptr])
            # res is the result string
            res = data[data_ptr + 1]
        except IndexError:
            # Should not happen if input is well-formed, but safe guard
            break
        
        data_ptr += 2
        
        # Use n-1 for 0-based indexing
        idx = n - 1
        
        if res == "WA" and not ju[idx]:
            pe[idx] += 1
        
        if res == "AC":
            ju[idx] = True

    # Calculate final output
    ac = 0
    wa = 0

    # Iterate through problems 0 to a-1
    for i in range(a):
        if ju[i]:
            ac += 1
            wa += pe[i]

    print(f"{ac} {wa}")

if __name__ == "__main__":
    solve()