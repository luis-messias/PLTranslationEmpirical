import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    # Read N, M, D from the first line
    try:
        nums = input_data[0].split()
        if len(nums) < 3:
            return
        N = int(nums[0])
        M = int(nums[1])
        D = int(nums[2])
    except ValueError:
        return

    # Read the room structure
    room = []
    for i in range(1, N + 1):
        if i < len(input_data):
            # Convert the line to a list of characters for easier indexing
            room.append(list(input_data[i].strip()))
        else:
            # Handle case where input might be truncated
            return

    # Initialize counter
    num = 0

    # --- setWE logic (Horizontal placements) ---
    # Check for horizontal segments of length D
    if M >= D:
        for i in range(N):  # Iterate rows
            for j in range(M - D + 1):  # Iterate starting columns
                can_put = True
                # Check the segment room[i][j] to room[i][j + D - 1]
                for k in range(D):
                    if room[i][j + k] == '#':
                        can_put = False
                        break
                
                if can_put:
                    num += 1

    # --- setNS logic (Vertical placements) ---
    # Check for vertical segments of length D
    if N >= D:
        for i in range(M):  # Iterate columns
            for j in range(N - D + 1):  # Iterate starting rows
                can_put = True
                # Check the segment room[j][i] to room[j + D - 1][i]
                for k in range(D):
                    if room[j + k][i] == '#':
                        can_put = False
                        break
                
                if can_put:
                    num += 1

    print(num)

solve()