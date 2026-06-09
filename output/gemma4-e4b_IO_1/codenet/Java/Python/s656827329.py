import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    try:
        n = int(data[0])
    except IndexError:
        # Handle case where input might be empty or malformed
        return

    if n == 0:
        print(0)
        return

    # A is the rest of the elements
    a = [int(x) for x in data[1:n+1]]

    if n == 1:
        print(1)
        return

    count = 1
    # now: current trend (1=up, -1=down, 0=flat/initial)
    now = 0
    # bef: previous established trend (1, -1, or 0 if reset)
    bef = 0
    
    for i in range(1, n):
        prev = a[i-1]
        curr = a[i]
        
        if prev < curr:
            now = 1
        elif prev > curr:
            now = -1
        else:
            # Flat segment, skip trend check for this pair
            continue 

        # Java logic replication
        if bef == 0:
            bef = now
        
        if bef != now:
            count += 1
            bef = 0
            
    print(count)

solve()
