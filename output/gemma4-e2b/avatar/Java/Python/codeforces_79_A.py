import sys

def can_take(x_needed, x_available, y_needed, y_available):
    if x_needed > x_available:
        return False
    if y_needed > y_available:
        return False
    return True

def solve():
    # Read the input line and parse x and y
    try:
        line = sys.stdin.readline()
        if not line:
            return
        x, y = map(int, line.split())
    except EOFError:
        return
    except ValueError:
        # Handle case where input might be malformed, though unlikely in competitive programming context
        return

    turn = 0
    while True:
        if turn % 2 == 0:  # Hanako's turn
            taken = False
            # Option 1: (x=2, y=2)
            if can_take(2, x, 2, y):
                x -= 2
                y -= 2
                taken = True
            # Option 2: (x=1, y=12)
            elif can_take(1, x, 12, y):
                x -= 1
                y -= 12
                taken = True
            # Option 3: (x=0, y=22)
            elif can_take(0, x, 22, y):
                y -= 22
                taken = True
            
            if not taken:
                print("Hanako")
                return
        else:  # Ciel's turn
            taken = False
            # Option 1: (x=0, y=22)
            if can_take(0, x, 22, y):
                y -= 22
                taken = True
            # Option 2: (x=1, y=12)
            elif can_take(1, x, 12, y):
                x -= 1
                y -= 12
                taken = True
            # Option 3: (x=2, y=2)
            elif can_take(2, x, 2, y):
                x -= 2
                y -= 2
                taken = True
            
            if not taken:
                print("Ciel")
                return
        
        turn += 1

solve()