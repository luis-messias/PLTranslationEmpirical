import sys

class IntegralRect:
    def __init__(self, h, w):
        self.height = h
        self.width = w

    def diagonal(self):
        # Replicating Java's Integer.MAX_VALUE behavior when height >= width
        # Since max possible diagonal is 200*200 + 200*200 = 80000, 
        # we use a large number to simulate Integer.MAX_VALUE.
        if self.height >= self.width:
            return 2**31 - 1 # A large number simulating Integer.MAX_VALUE
        return self.height * self.height + self.width * self.width

    def get_sort_key(self):
        # The comparison logic (diagonal, height) determines the sort order
        return (self.diagonal(), self.height)

def solve():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # --- Initialization Phase ---
    
    # 1. Initialize rects array (200x200)
    rects = []
    for i in range(200):
        for j in range(200):
            rects.append(IntegralRect(i + 1, j + 1))
    
    # 2. Sort rects using the defined comparison logic (diagonal, then height)
    # Python's tuple comparison handles the required sorting order naturally.
    rects.sort(key=IntegralRect.get_sort_key)

    # --- Processing Phase ---
    
    output = []
    input_index = 0
    
    while input_index < len(input_data):
