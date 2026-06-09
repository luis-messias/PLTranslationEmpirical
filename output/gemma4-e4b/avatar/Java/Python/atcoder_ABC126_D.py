import sys
from collections import defaultdict

# Set recursion limit higher for deep DFS calls
sys.setrecursionlimit(2000)

class Point:
    """Represents a point (node) in the graph."""
    def __init__(self, name):
        self.name = name
        # friends maps Point object -> length (integer)
        self.friends = {}

    def become_friend(self, p, length):
        """Adds a connection to another point."""
        self.friends[p] = length

class AtcoderABC126D:
    """Main class to solve the problem."""
    
    def __init__(self):
        # colors[i] stores the color of point i. -1 means uncolored.
        self.colors = []
        self.points = []

    def dfs(self, p, length):
        """
        Depth First Search function to color the points.
        p: current Point object
        length: accumulated length from the starting point (0)
        """
        # Check if the color is already known (i.e., not -1)
        if self.colors[p.name] != -1:
            return

        # Determine color based on parity of total length
        if length % 2 == 0:
            self.colors[p.name] = 0
        else:
            self.colors[p.name] = 1

        # Recurse through friends
        for friend, length2 in p.friends.items():
            self.dfs(friend, length + length2)

    def solve(self):
        """Reads input, builds graph, runs DFS, and prints results."""
        
        # Read all input data
        data = sys.stdin.read().split()
        if not data:
            return

        data_ptr = 0
        
        # N is the number of points
        try:
            n = int(data[data_ptr])
            data_ptr += 1
        except IndexError:
            return # Handle empty input

        m = n - 1
        
        # Initialize colors array
        self.colors = [-1] * n
        
        # Initialize Point objects
        self.points = [Point(i) for i in range(n)]
        
        # Process edges
        for _ in range(m):
            try:
                # Input indices are 1-based, convert to 0-based
                me_id = int(data[data_ptr]) - 1
                you_id = int(data[data_ptr + 1]) - 1
                length = int(data[data_ptr + 2])
                data_ptr += 3
            except IndexError:
                # Should not happen if input is well-formed
                break

            me_point = self.points[me_id]
            you_point = self.points[you_id]
            
            # Build bidirectional edges
            me_point.become_friend(you_point, length)
            you_point.become_friend(me_point, length)

        # Start DFS from point 0 with initial length 0
        self.dfs(self.points[0], 0)
        
        # Print results
        for c in self.colors:
            print(c)

if __name__ == "__main__":
    AtcoderABC126D().solve()