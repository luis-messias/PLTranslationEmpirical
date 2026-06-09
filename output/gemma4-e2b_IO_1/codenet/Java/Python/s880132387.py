import sys

def solve():
    # Read all input data
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    data_ptr = 0
    results = []

    while data_ptr < len(input_data):
        try:
            # Read W and H
            W = int(input_data[data_ptr])
            H = int(input_data[data_ptr + 1])
            data_ptr += 2
        except IndexError:
            break
        except ValueError:
            # Handle case where W or H are not integers (shouldn't happen with valid input structure)
            break

        if W == 0 and H == 0:
            break

        # Read the map (H rows)
        map = []
        for h in range(H):
            if data_ptr < len(input_data):
                row_str = input_data[data_ptr]
                map.append(row_str)
                data_ptr += 1
            else:
                # Input truncated
                break
        
        if len(map) != H:
            # Incomplete test case data
            continue

        # DP calculation
        # dp[h][w] stores the largest number formed by digits in the rectangle ending at (h, w)
        dp = [[0] * W for _ in range(H)]

        for h in range(H):
            for w in range(W):
                current_char = map[h][w]
                
                if not current_char.isdigit():
                    dp[h][w] = 0
                    continue
                
                digit = int(current_char)
                
                # Determine previous values
                hprev = 0
                if h > 0:
                    hprev = dp[h-1][w]
                
                wprev = 0
                if w > 0:
                    wprev = dp[h][w-1]
                
                # Determine the maximum previous number
                max_prev = max(hprev, wprev)
                
                # Calculate the new value: max_prev * 10 + current_digit
                # Since Python integers handle large numbers, we don't need BigInteger explicitly.
                dp[h][w] = max_prev * 10 + digit

        # Find the overall maximum in the DP table
        max_val =
