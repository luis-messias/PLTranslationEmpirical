import sys

def solve():
    # Read all input tokens
    try:
        data = list(map(int, sys.stdin.read().split()))
    except:
        return

    if not data:
        return

    if len(data) == 0:
        return

    try:
        n = data[0]
    except ValueError:
        return

    data_ptr = 1
    
    for _ in range(n):
        # Check if we have enough data for the triplet
        if data_ptr + 2 >= len(data):
            break
            
        # Read the triplet a[0], a[1], a[2]
        a0 = data[data_ptr]
        a1 = data[data_ptr + 1]
        a2 = data[data_ptr + 2]
        
        # Sort the triplet
        a = sorted([a0, a1, a2])
        
        # Check Pythagorean relationship: a[2]^2 == a[0]^2 + a[1]^2
        # Using integer multiplication is safer and faster than Math.pow()
        if a[2] * a[2] == a[0] * a[0] + a[1] * a[1]:
            print("YES")
        else:
            print("NO")
            
        data_ptr += 3

solve()
