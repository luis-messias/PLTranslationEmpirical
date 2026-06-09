import sys

def solve():
    # Read input string s
    try:
        s = sys.stdin.readline().strip()
    except EOFError:
        return
    
    if not s:
        # Handle empty input if necessary, though constraints usually prevent this
        return

    # Initialize variables
    x = 0
    y = 0
    k = 0
    dx = 0
    dy = 0
    flag = True
    
    # co[0] stores x coordinates, co[1] stores y coordinates. 
    # The maximum size needed is based on the Java code's array size [101] for k up to 100.
    # Since s.length() is at most 100, k will go up to 100.
    co = [[0] * 101 for _ in range(2)]
    
    # Store initial position (0, 0) at index 0
    co[0][0] = x
    co[1][0] = y
    k = 1
    
    # Process moves
    s_list = list(s)
    for move in s_list:
        if move == 'L':
            x -= 1
        elif move == 'R':
            x += 1
        elif move == 'U':
            y += 1
        elif move == 'D':
            y -= 1
        
        # Store current position at index k
        co[0][k] = x
        co[1][k] = y
        k += 1

    # Check for self-intersection
    # The Java code uses k as the total number of points recorded (N+1)
    # The loop iterates over pairs (i, j) where j >= i + 3
    
    # k is the total number of points recorded (N+1)
    # The loop condition is i < k - 3