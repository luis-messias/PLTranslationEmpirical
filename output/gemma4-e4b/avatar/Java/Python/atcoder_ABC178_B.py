import sys

def solve():
    # Read all inputs from stdin and convert them to integers
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        # We only need the first 4 elements
        a = [int(x) for x in data[:4]]
    except Exception:
        return

    # Calculate the four products and find the maximum
    # max(a[0]*a[2], a[1]*a[3], a[0]*a[3], a[1]*a[2])
    result = max(a[0] * a[2], a[1] * a[3], a[0] * a[3], a[1] * a[2])
    
    print(result)

if __name__ == "__main__":
    solve()