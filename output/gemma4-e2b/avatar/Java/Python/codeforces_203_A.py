import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Parse inputs based on the Java structure: x, t, a, b, da, db
    try:
        x = int(data[0])
        t = int(data[1])
        a = int(data[2])
        b = int(data[3])
        da = int(data[4])
        db = int(data[5])
    except IndexError:
        # Handle case where not enough input is provided
        return
    except ValueError:
        # Handle case where input is not an integer
        return

    ok = False
    
    # Outer loop for i
    for i in range(t):
        first = a - (da * i)
        
        # Inner loop for j
        for j in range(t):
            second = b - (db * j)
            
            # Check condition: second + first == x || second == x || first == x || x == 0
            if (second + first == x or 
                second == x or 
                first == x or 
                x == 0):
                
                ok = True
                # Break the inner loop (j loop)
                break
        
        # If ok is set, we can break the outer loop (i loop)
        if ok:
            break

    if ok:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    solve()