import sys

def solve():
    # Read all input tokens and map them to integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        x1 = int(data[0])
        y1 = int(data[1])
        x2 = int(data[2])
        y2 = int(data[3])
    except IndexError:
        # Handle case where not enough input is provided
        return

    if x1 == x2:
        dif = abs(y1 - y2)
        print(f"{x1 + dif} {y1} {x1 + dif} {y2}")
    elif y1 == y2:
        dif = abs(x1 - x2)
        print(f"{x1} {y1 + dif} {x2} {y2 + dif}")
    elif abs(x1 - x2) == abs(y1 - y2):
        print(f"{x1} {y2} {x2} {y1}")
    else:
        print("-1")

if __name__ == "__main__":
    solve()