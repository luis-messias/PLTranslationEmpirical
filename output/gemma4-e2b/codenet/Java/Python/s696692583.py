import sys

def solve(a):
    s = ['d', 'o', 'x']
    for side in range(1, 3):
        # Check row/column patterns
        for i in range(3):
            # Check if a row is entirely 'side'
            if a[i][0] == side and a[i][1] == side and a[i][2] == side:
                return s[side]
            # Check if a column is entirely 'side'
            if a[0][i] == side and a[1][i] == side and a[2][i] == side:
                return s[side]

        # Check main diagonal
        if a[0][0] == side and a[1][1] == side and a[2][2] == side:
            return s[side]
        
        # Check anti-diagonal
        if a[0][2] == side and a[1][1] == side and a[2][0] == side:
            return s[side]
            
    return 'd'

def run():
    # Read input from stdin
    for line in sys.stdin:
        try:
            # Read the line and split into integers
            parts = list(map(int, line.split()))
            if len(parts) < 3:
                continue
            
            my1 = parts[0]
            my2 = parts[1]
            enemy1 = parts[2]

            # Logic from Java run method
            used = [False] * 11
            
            # Ensure indices are within bounds if necessary, though the logic assumes 1-10
            if 1 <= my1 <= 10: used[my1] = True
            if 1 <= my2 <= 10: used[my2] = True
            if 1 <= enemy1 <= 10: used[enemy1] = True
            
            all_unused = 0
            safe_count = 0
            
            # Check numbers 1 through 10
            for i in range(1, 11):
                if not used[i]:
                    all_unused += 1
                    # The condition used in Java: my1 + my2 + i <= 20
                    if my1 + my2 + i <= 20:
                        safe_count += 1
            
            if all_unused > 0:
                if safe_count * 2 >= all_unused:
                    print("YES")
                else:
                    print("NO")
            # Note: The Java code implicitly handles the loop continuation based on hasNext(), 
            # which implies reading until EOF.

        except ValueError:
            # Skip lines that don't contain valid integers
            continue

if __name__ == "__main__":
    # The Java code structure implies reading input continuously.
    # We simulate this by reading from stdin.
    run()