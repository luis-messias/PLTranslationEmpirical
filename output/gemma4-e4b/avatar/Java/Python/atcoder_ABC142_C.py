import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    try:
        N = int(input_data[0])
    except IndexError:
        return

    # idorder maps value A to its input index i (1-based)
    idorder = {}

    # The remaining N elements are A_1, A_2, ..., A_N
    # They start from index 1 in input_data
    for i in range(1, N + 1):
        try:
            A = int(input_data[i])
            # Store A -> i (1-based index)
            idorder[A] = i
        except IndexError:
            # Should not happen if input matches N
            break

    # Output the stored order for keys 1 through N
    result = []
    for i in range(1, N + 1):
        # We assume key i exists based on the problem constraints/Java logic
        if i in idorder:
            result.append(str(idorder[i]))
        # If key i is missing, the Java code would likely throw a NullPointerException 
        # if it were using get(i) on a map that might not contain i, 
        # but since the Java code assumes the keys 1..N exist, we proceed assuming they do.

    print(" ".join(result))

solve()