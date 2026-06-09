import sys

def solve():
    # Read all input from stdin and map to integers. 
    # This handles inputs provided on a single line or multiple lines separated by whitespace.
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        a = int(data[0])
        b = int(data[1])
        c = int(data[2])
    except Exception:
        # Handle case where input reading fails
        return

    # Check the condition: a < b AND b < c AND a < c
    if a < b and b < c and a < c:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    solve()