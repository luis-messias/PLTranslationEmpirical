import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # The first line contains H and W
    try:
        H, W = map(int, input_data[0].split())
    except ValueError:
        # Handle case where H W line is malformed
        return

    # The grid starts from the second line
    S = []
    for i in range(H):
        if i + 1 < len(input_data):
            S.append(list(input_data[i + 1]))
        else:
            # Handle case where input ends prematurely
            return

    # Process the grid
    for i in range(H):
        for j in range(W):
            if S[i][j] == '.':
                count = 0
                
                # Check all 9 neighbors (including self)
                for a in [-1, 0, 1]:
                    ni = i + a
                    if ni < 0 or ni >= H:
                        continue
                    
                    for b in [-1, 0, 1]:
                        nj = j + b