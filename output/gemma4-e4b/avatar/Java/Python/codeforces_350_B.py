import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Helper function to consume input tokens
    data_iter = iter(input_data)
    
    try:
        n = int(next(data_iter))
    except StopIteration:
        return

    # Initialize arrays (1-indexed, so size n+1)
    # We use 0-indexing internally but treat indices 1 to n as valid.
    a = [0] * (n + 1)
    b = [0] * (n + 1)
    
    # Read array a
    for i in range(1, n + 1):
        try:
            a[i] = int(next(data_iter))
        except StopIteration:
            break

    # Read array b
    for i in range(1, n + 1):
        try:
            b[i] = int(next(data_iter))
        except StopIteration:
            break

    # num[j] counts frequency of j in b
    num = [0] * (n + 1)
    for i in range(1, n + 1):
        if b[i] <= n: # Ensure index is within bounds if b[i] can exceed n
            num[b[i]] += 1

    ans = 0
    ss = ""
    st = [False] * (n + 1)

    for i in range(1, n + 1):
        if a[i] == 1:
            if st[i]:
                continue
            
            st[i] = True
            
            # Path tracking list
            path_elements = []
            current_path_length = 0
            
            x = b[i]
            
            # Start path construction
            path_elements.append(str(i))
            current_path_length = 1
            
            # While loop condition check
            while st[x] == False and num[x] == 1 and x != 0 and a[x] != 1:
                
                # Append x to the path
                path_elements.append(str(x))
                
                # Mark visited
                st[x] = True
                
                # Move to next node
                x = b[x]
                current_path_length += 1
            
            # Check if this path is the longest found so far
            if current_path_length > ans:
                ans = current_path_length
                
                # Replicate Java's string building and reversal:
                # 1. Join elements: "i x1 x2 ..."
                # 2. The Java code builds " 1 2 3 " (with leading/trailing spaces)
                # 3. Then it reverses the whole string.
                
                # Construct the string as it would appear in Java (space separated, potentially with leading/trailing spaces)
                # Since the Java code appends