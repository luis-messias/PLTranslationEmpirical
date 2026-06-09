import sys
import io

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # Since the Java code uses sc.nextInt() sequentially, we process input_data sequentially.
    
    # We need to handle the input stream carefully based on how the Java code reads it.
    # The Java code reads W, H, then H lines of map data.
    
    # We will simulate reading from stdin sequentially.
    
    # Since the input format is not explicitly defined beyond the Java structure, 
    # we assume the input stream provides W, H, followed by the map data.
    
    # In competitive programming contexts, reading all tokens and processing them is common.
    
    # Replicating the structure of reading W, H, and then H rows of characters.
    
    # If we assume the input is provided exactly as the Java code expects (W, H, then H lines of map data):
    
    # We need to handle the input stream as if it were provided line by line or token by token.
    
    # Let's use sys.stdin.read().split() to get all tokens.
    
    if not input_data:
        return

    # The first two tokens are W and H
    try:
        W = int(input_data[0])
        H = int(input_data[1])
    except IndexError:
        return # Not enough input

    if W == 0 and H == 0:
        return

    # The remaining tokens form the map rows.
    map_data = input_data[2:]
    
    # Reconstruct the map from the tokens. Since map data is read as strings, 
    # we assume each row is provided as a single string token.
    
    map = []
    current_token_index = 0
    
    # The Java code reads H lines of input for the map.
    for _ in range(H):
        if current_token_index < len(map_data):
            # Assuming the map row is provided as a single string token
            row_str = map_data[current_token_index]
            map.append(list(row_str))
            current_token_index += 1
        else:
            # Handle case where input might be truncated
            break

    if len(map) != H:
        # Handle error if map reading failed to get H rows
        return

    # DP initialization
    # Use Python's native large integers (which handle BigInteger functionality)
    dp = [[0] * W for _ in range(H)]

    # DP calculation
    for h in range(H):
        for w in range(W):
            if not map[h][w].isdigit():
                dp[h][w] = 0
                continue
            
            digit = int(map[h][w])
            
            hprev = 0
            if h > 0:
                hprev = dp[h-1][w]
            
            wprev = 0
            if w > 0:
                wprev = dp[h][w-1]
            
            # Determine the maximum previous number
            max_prev = max(hprev, wprev)
            
            # Calculate the new value: max_prev * 10 + current_digit
            dp[h][w] = max_prev * 10 + digit

    # Find the overall maximum
    max_val = 0
    for h in range(H):
        for w in range(W):
            if dp[h][w] > max_val:
                max_val = dp[h][w]
                
    # Print the result
    print(max_val)

solve()