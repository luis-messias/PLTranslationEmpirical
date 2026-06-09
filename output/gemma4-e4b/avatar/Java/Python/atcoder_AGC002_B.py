import sys

class Box:
    def __init__(self, n, r):
        self.num = n
        self.red = r

    def move_to(self, other):
        if self.num == 0:
            return
        elif self.num == 1:
            self.num = 0
            other.num += 1
            if self.red:
                other.red = True
            self.red = False
        else:
            self.num -= 1
            other.num += 1
            if self.red:
                other.red = True

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N = number of boxes, M = number of moves
    N = int(data[0])
    M = int(data[1])
    
    # Initialize boxes array (list in Python)
    B = []
    
    # B[0] initialization
    B.append(Box(1, True))
    
    # B[i] initialization for i > 0
    for _ in range(1, N):
        B.append(Box(1, False))

    # Process M moves
    data_index = 2
    for _ in range(M):
        if data_index + 1 >= len(data):
            break
            
        # x and y are 1-based in input, convert to 0-based indices
        x = int(data[data_index]) - 1