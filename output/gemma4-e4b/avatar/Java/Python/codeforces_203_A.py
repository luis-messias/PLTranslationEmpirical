import sys

def solve():
    # Read all input tokens and map them to integers
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        # Handle case where no input is provided
        return

    if len(data) < 6:
        # Not enough input data
        return

    x, t, a, b, da, db = data[:6]

    ok = False
    
    # Loop for i (first sequence)
    for i in range(t):
        first = a - (da * i)
        
        # Loop for j (second sequence)
        for j in range(t):
            second = b - (db * j)
            
            # Check the condition: second + first == x OR second == x OR first == x OR x == 0
            if second + first == x or second == x or first == x or x == 0:
                ok = True
                break
        
        if ok:
            break

    if ok:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    solve()