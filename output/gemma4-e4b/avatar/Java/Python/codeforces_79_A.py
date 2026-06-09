import sys

def canTake(xNeeded, xAvailable, yNeeded, yAvailable):
    if xNeeded > xAvailable:
        return False
    if yNeeded > yAvailable:
        return False
    return True

def solve():
    try:
        # Read input from stdin
        line = sys.stdin.readline()
        if not line:
            return
        
        parts = line.split()
        if len(parts) < 2:
            return

        x = int(parts[0])
        y = int(parts[1])
    except EOFError:
        return
    except ValueError:
        return

    turn = 0
    while True:
        if turn % 2 == 0:  # Hanako's turn
            # Try moves in order: (2, 2), (1, 12), (0, 22)
            if canTake(2, x, 2, y):
                x -= 2
                y -= 2
            elif canTake(1, x, 12, y):
                x -= 1
                y -= 12
            elif canTake(0, x, 22, y):
                y -= 22
            else:
                print("Hanako")
                return
        else:  # Ciel's turn
            # Try moves in order: (0, 22), (1, 12), (2, 2)
            if canTake(0, x, 22, y):
                y -= 22
            elif canTake(1, x, 12, y):
                x -= 1
                y -= 12
            elif canTake(2, x, 2, y):
                x -= 2
                y -= 2
            else:
                print("Ciel")
                return
        
        turn += 1

solve()