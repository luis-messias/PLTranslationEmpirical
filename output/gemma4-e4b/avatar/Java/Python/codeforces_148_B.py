import sys

def solve():
    # Read all inputs from standard input and map them to floats
    try:
        data = [float(x) for x in sys.stdin.read().split()]
        if len(data) < 5:
            return
        
        VP = data[0]
        VD = data[1]
        T = data[2]
        F = data[3]
        C = data[4]
    except Exception:
        return

    if VD <= VP:
        print("0")
        return

    answer = 0
    start = T
    
    while True:
        # Calculate x
        x = start * VP / (VD - VP)
        
        # Check termination condition
        if (start + x) * VP >= C:
            break
        
        # Update start
        start += 2 * x + F
        
        # Increment answer
        answer += 1
        
    print(answer)

if __name__ == "__main__":
    solve()