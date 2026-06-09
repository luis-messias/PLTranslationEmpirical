import sys

def solve():
    # Read N, M, D from the first line of input
    try:
        first_line = sys.stdin.readline().strip()
        if not first_line:
            return
        
        parts = first_line.split()
        N = int(parts[0])
        M = int(parts[1])
        D = int(parts[2])
    except Exception:
        # Handle case where input might be malformed or empty
        return

    # Read the room grid (N rows, M columns)
    room = []
    for _ in range(N):
        line = sys.stdin.readline().strip()
        if line:
            room.append(list(line))
        else:
            # Handle case where expected rows are missing
            break
    
    # Ensure we have N rows, although the input reading structure assumes it.
    # We will use the actual dimensions of the read room if necessary, 
    # but for translation fidelity, we assume N rows were read.
    
    global num
    num = 0

    # --- setWE (Horizontal placement: 1 x D) ---
    if M >= D:
        for i in range(N):  # Row index
            for j in range(M - D + 1):  # Starting column index
                can_put = True
                # Check segment from j to j + D - 1
                for k in range(D):
                    if room[i][j + k] == '#':
                        can_put = False
                        break
                
                if can_put:
                    num += 1

    # --- setNS (Vertical placement: D x 1) ---
    if N >= D:
        # i represents the column index (0 to M-1)
        for i in range(M):
            # j represents the starting row index (0 to N - D)
            for j in range(N - D + 1):
                can_put = True
                # Check segment from row j to j + D - 1 in column i
                for k in range(D):
                    if room[j + k][i] == '#':
                        can_put = False
                        break
                
                if can_put:
                    num += 1

    print(num)

if __name__ == "__main__":
    # Since the original Java code uses static variables and global state, 
    # we wrap the logic in a function to manage scope and execution flow.
    solve()