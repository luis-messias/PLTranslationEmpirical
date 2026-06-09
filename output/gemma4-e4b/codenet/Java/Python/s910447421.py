import sys
import math

# Set recursion limit higher for safety, although not strictly necessary for this problem structure
# sys.setrecursionlimit(2000)

def solve():
    """
    Calculates the minimum maximum length of the arithmetic progression found 
    by fixing the first two points (balls[0] and balls[add]).
    """
    global ans
    N = len(balls)
    
    # Iterate through all possible second points (add > 0)
    for add in range(1, N):
        # Reset taken array for each pair (p, q)
        taken = [False] * N
        
        # Calculate the difference vector (p, q)
        p = balls[add][0] - balls[0][0]
        q = balls[add][1] - balls[0][1]
        
        # Update ans with the minimum result found
        ans = min(ans, check(p, q))

def check(p, q):
    """
    Checks the maximum length of the arithmetic progression defined by (p, q) 
    starting from the first available point.
    """
    global N
    taken = [False] * N
    ret = 0
    
    # The loop continues as long as we can find an untaken starting point
    while True:
        added = False
        start_index = -1
        x, y = -1, -1  # Coordinates of the point we want next
        
        # 1. Find the first untaken point (P_1)
        for i in range(N):
            if not taken[i]:
                added = True
                ret += 1
                start_index = i
                taken[i] = True
                
                # Calculate the coordinates of the next expected point (P_2)
                x = balls[i][0] + p
                y = balls[i][1] + q
                break
        
        if not added:
            break
        
        # 2. Find subsequent points (P_2, P_3, ...)
        # We check all points after the starting point index
        for i in range(start_index + 1, N):
            # Check if the point matches the expected coordinates (x, y)
            if balls[i][0] == x and balls[i][1] == y:
                # Found the next point in the sequence
                taken[i] = True
                
                # Update expected coordinates for the point after this one
                x += p
                y += q
                
    return ret

def main():
    global ans, balls, N
    
    # --- Input Reading ---
    try:
        # Read N
        N = int(sys.stdin.readline())
    except:
        # Handle empty input case
        N = 0
        
    if N == 0:
        print(0)
        return

    # Read coordinates
    balls = []
    for _ in range(N):
        try:
            line = sys.stdin.readline().split()
            if line:
                x = int(line[0])
                y = int(line[1])
                balls.append((x, y))
        except EOFError:
            break
        except IndexError:
            # Handle case where input might be malformed
            break

    # Initialize ans to N (maximum possible length)
    ans = N

    # --- Case 1: Original coordinates (x, y) ---
    
    # Sort by x-coordinate (primary key)
    # Python's sort is stable and sorts tuples lexicographically, which is equivalent to sorting by x then y.
    balls.sort()
    
    solve()

    # --- Case 2: Swapped coordinates (y, x) ---
    
    # Swap coordinates: (x, y) -> (y, x)
    # We must create a new list or modify the existing one carefully.
    swapped_balls = []
    for x, y in balls:
        swapped_balls.append((y, x))
    
    balls = swapped_balls
    
    # Sort the swapped coordinates by the new x-coordinate (which was the original y)
    balls.sort()
    
    solve()

    # --- Output ---
    print(ans)

if __name__ == "__