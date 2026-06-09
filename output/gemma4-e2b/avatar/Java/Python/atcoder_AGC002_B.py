import sys

class Box:
    def __init__(self, n, r):
        self.num = n
        self.red = r

    def moveTo(self, other):
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
    # Read all input from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N and M are the first two integers
    N = int(data[0])
    M = int(data[1])
    
    # Initialize boxes
    B = [None] * N
    
    # Box 0 starts at (1, true)
    B[0] = Box(1, True)
    
    # Other boxes start at (1, false)
    for i in range(1, N):
        B[i] = Box(1, False)
        
    # Process M moves
    data_idx = 2
    for _ in range(M):
        if data_idx + 1 >= len(data):
            break
            
        # x is the destination index, y is the source index
        x = int(data[data_idx]) - 1
        y = int(data[data_idx+1]) - 1
        data_idx += 2
        
        if 0 <= x < N and 0 <= y < N:
            B[x].moveTo(B[y])

    # Count red boxes
    counter = 0
    for b in B:
        if b.red:
            counter += 1
            
    print(counter)

solve()