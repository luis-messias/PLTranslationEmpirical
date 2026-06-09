import sys

def main():
    # Read N and M from the first line
    try:
        line = sys.stdin.readline()
        if not line:
            return
        N, M = map(int, line.split())
    except:
        return

    shortage = []

    # Read the next M lines for A values
    for _ in range(M):
        line = sys.stdin.readline()
        if not line:
            break
        
        try:
            # Extract A (the first number on the line)
            A = int(line.split()[0])
            
            # Calculate shortage: max(0, N - A)
            shortage_val = max(0, N - A)
            shortage.append(shortage_val)
        except:
            # Skip line if parsing fails
            continue

    # Sort the shortage array
    shortage.sort()