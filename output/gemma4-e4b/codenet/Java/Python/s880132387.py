import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_index = 0

    while data_index < len(input_data):
        try:
            W = int(input_data[data_index])
            H = int(input_data[data_index + 1])
            data_index += 2
        except IndexError:
            # Should not happen if input is well-formed, but handles EOF
            break

        if W == 0 and H == 0:
            break

        map_chars = []
        # Read H rows, where each row is a string of characters
        for h in range(H):
            if data_index >= len(input_data):
                # Handle case where input ends prematurely
                return
            
            # The Java code reads the entire row as a single token/string
            row_str = input_data[data_index]
            map_chars.append(row_str)
            data_index += 1

        # dp[h][w] stores the calculated value
        dp = [[0] * W for _ in range(H)]

        for h in range(H):
            for w in range(W):
                char = map_chars[h][w]
                
                if char.isdigit():
                    digit = int(char)
                    
                    h_prev = 0
                    if h >= 1:
                        h_prev = dp[h-1][w]
                    
                    w_prev = 0
                    if w >= 1:
                        w_prev = dp[h][w-1]
                    
                    # Determine max(h_prev, w_prev)
                    max_prev = max(h_prev, w_prev)
                    
                    # Calculate dp[h][w] = max_prev * 10 + digit
                    dp[h][w] = max_prev * 10 + digit
                else:
                    dp[h][w] = 0

        # Find the maximum value in the entire DP table
        max_val = 0
        for h in range(H):
            for w in range(W):
                if dp[h][w] > max_val:
                    max_val = dp[h][w]
        
        print(max_val)

if __name__ == "__main__":
    solve()