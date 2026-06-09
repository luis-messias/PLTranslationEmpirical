import sys

def main():
    # Read all input lines
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and M are the first two numbers
    N = int(data[0])
    M = int(data[1])
    
    if M == 0:
        print(0)
        return

    shortage = []
    data_idx = 2
    
    # Read the next M lines, each containing A_i
    for _ in range(M):
        if data_idx >= len(data):
            break
            
        # The input format seems to be N M followed by M pairs of A_i, 
        # where each A_i is on a new line, potentially with other numbers on that line.
        # The Java code reads line by line and parses A from that line.
        
        # Since we read everything into a flat list `data`, we need to reconstruct the line reading behavior.
        # Let's revert to reading line by line using sys.stdin.readline() to mimic the Java structure more closely, 
        # as the input structure implies line separation.
        pass # Re-implementing input reading below based on line structure.

def solve():
    input_lines = sys.stdin.readlines()
    if not input_lines:
        return

    try:
        # Read N and M from the first line
        N, M = map(int, input_lines[0].split())
    except ValueError:
        return

    shortage = []

    # Read the next M lines for A values
    for i in range(1, M + 1):
        if i >= len(input_lines):
            break
            
        line = input_lines[i].strip()
        if not line:
            continue
            
        try:
            # Extract A (the first number on the line)
            parts = line.split()
            if not parts:
                continue
            A = int(parts[0])
            
            # Calculate shortage: max(0, N - A)
            shortage_val = max(0, N - A)
            shortage.append(shortage_val)
        except ValueError:
            # Skip line if parsing fails
            continue

    # Sort the shortage array
    shortage.sort()

    # Calculate the sum of the first M-1 elements
    ans = 0
    # We sum up to index M-2 (M-1 elements)
    for i in range(M - 1):
        if i < len(shortage):
            ans += shortage[i]

    print(ans)

solve()
