import sys

def solve():
    # Read inputs from standard input
    try:
        VP = float(sys.stdin.readline())
        VD = float(sys.stdin.readline())
        T = float(sys.stdin.readline())
        F = float(sys.stdin.readline())
        C = float(sys.stdin.readline())
    except:
        # Handle case where input might be incomplete or invalid
        return

    if VD <= VP:
        print("0")
        return

    answer = 0
    start = T
    
    # The loop structure
    while True:
        # x = start * VP / (VD - VP)
        # Since we checked VD > VP, (VD - VP) is positive
        x = start * VP / (VD - VP)
        
        # if (start + x) * VP >= C
        if (start + x) * VP >= C:
            break
            
        # start += 2 * x + F
        start += 2 * x + F
        
        answer += 1
        
    print(answer)

solve()