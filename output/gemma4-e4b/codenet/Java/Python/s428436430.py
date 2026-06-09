class calArea:
    def Area(self, w: int, h: int) -> int:
        return w * h

def main():
    import sys
    # Read all inputs from stdin and convert them to a list of integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        arr = [int(x) for x in data[:4]]
    except Exception:
        return

    if len(arr) < 4:
        return

    ab = calArea()
    
    # Calculate the two areas
    area1 = ab.Area(arr[0], arr[1])
    area2 = ab.Area(arr[2], arr[3])
    
    # Print the maximum of the two areas
    print(max(area1, area2))

if __name__ == "__main__":
    main()