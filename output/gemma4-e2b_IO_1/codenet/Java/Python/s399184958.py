import sys

try:
    # Read all space-separated integers from standard input
    data = sys.stdin.read().split()
    
    if len(data) >= 3:
        A = int(data[0])
        B = int(data[1])
        C = int(data[2])
        
        if A == B and B == C and C == A:
            print("Yes")
        else:
            print("No")
    
except:
    # Handle case where input might be missing or invalid
    pass
