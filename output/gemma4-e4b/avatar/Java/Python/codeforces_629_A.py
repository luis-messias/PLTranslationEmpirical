import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is num
    try:
        num = int(input_data[0])
    except ValueError:
        # Handle case where input might be malformed
        return

    # The remaining elements are the strings
    arr = input_data[1:num + 1]
    
    fine = 0
    
    # --- 1. Column-wise check ---
    # We assume all strings are at least length 'num' based on the original Java logic.
    # The number of columns to check is determined by the minimum length of the strings, 
    # but since the Java code iterates up to 'num', we stick to that limit.
    
    # Determine the actual number of columns to check (min length of all strings)
    # If we strictly follow the Java code, we iterate up to 'num'.
    num_cols = num
    
    for i in range(num_cols): # i is the column index
        counter = 0
        for k in range(num): # k is the string index
            # Check if the string arr[k] has a character at index i
            if i < len(arr[k]) and arr[k][i] == 'C':
                counter += 1
        
        # Calculate combinations: counter * (counter - 1) / 2
        fine += (counter * (counter - 1)) // 2
        
    # --- 2. Row-wise check ---
    for i in range(num): # i is the string index
        s = arr[i]
        counter = 0
        
        # Count 'C's in the current string s
        for k in range(len(s)): # k is the character index
            if s[k] == 'C':
                counter += 1
        
        # Calculate combinations
        fine += (counter * (counter - 1)) // 2
        
    print(fine)

solve()