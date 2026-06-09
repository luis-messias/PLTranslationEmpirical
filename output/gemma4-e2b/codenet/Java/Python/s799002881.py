import sys
import math

def main():
    # Read the first line containing n and d
    try:
        line1 = sys.stdin.readline()
        if not line1:
            return
        parts = line1.split()
        if len(parts) < 2:
            return
        n = int(parts[0])
        d = int(parts[1])
    except Exception:
        return

    cnt = 0

    # Read the next n lines containing x and y
    for _ in range(n):
        line = sys.stdin.readline()
        if not line:
            break
        
        try:
            x, y = map(int, line.split())
            
            # Check if distance is less than or equal to d
            if math.sqrt(x*x + y*y) <= d:
                cnt += 1
        except ValueError:
            # Skip lines that don't contain two integers
            continue

    print(cnt)

if __name__ == "__main__":
    main()