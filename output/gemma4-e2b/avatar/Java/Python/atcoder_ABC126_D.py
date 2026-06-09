import sys

class Point:
    def __init__(self, name):
        self.name = name
        # friends maps another Point object to the length of the friendship
        self.friends = {}

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Input parsing starts from index 0
    data_ptr = 0
    
    # N is the number of points
    n = int(input_data[data_ptr])
    data_ptr += 1
    
    # m is implicitly n - 1, but the loop structure suggests reading m operations
    # The Java code sets m = n - 1 and loops m times.
    m = n - 1
    
    # Initialize colors array (size n, initialized to -1)
    colors = [-1] * n
    
    # Initialize points list
    points = []
    for i in range(n):
        points.append(Point(i))
        
    # Process M friendship operations
    for _ in range(m):
        if data_ptr + 2 >= len(input_data):
            break
            
        me = int(input_data[data_ptr]) - 1
        you = int(input_data[data_ptr + 1]) - 1
        length = int(input_data[data_ptr + 2])
        data_ptr += 3
        
        # points[me].becomeFriend(points[you], length)
        points[me].friends[points[you]] = length
        # points[you].becomeFriend(points[me], length)
        points[you].friends[points[me]] = length

    # DFS function definition
    def dfs(p: Point, length: int):
        # Check if already known (colors[p.name] != -1)
        if colors[p.name] != -1:
            return

        # Assign color based on length parity
        if length % 2 == 0:
            colors[p.name] = 0
        else:
            colors[p.name] = 1
            
        # Recurse over friends
        for friend, length2 in p.friends.items():
            dfs(friend, length + length2)

    # Start DFS from point 0 with initial length 0
    if n > 0:
        dfs(points[0], 0)

    # Output results
    for c in colors:
        print(c)

solve()