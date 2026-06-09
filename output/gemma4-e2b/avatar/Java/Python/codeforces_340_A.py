import sys

def solve():
    # Read four long integers x, y, a, b
    try:
        x = int(sys.stdin.readline())
        y = int(sys.stdin.readline())
        a = int(sys.stdin.readline())
        b = int(sys.stdin.readline())
    except:
        # Handle potential empty input if running interactively without proper input stream setup
        return

    # Initialization
    j = 2
    # x1, y1 are unused in the logic flow, initialized to 0
    c = 0
    ans = True

    c = max(x, y)

    # First check
    if c > b:
        print("0")
        ans = False
    else:
        # Main loop
        while c % min(x, y) != 0 and ans:
            if x > y:
                c = x * j
            else:
                c = y * j
            j += 1

            if c > b:
                print("0")
                ans = False
                break

        # Final calculation if ans is true
        if ans:
            # Find the first multiple of c in the range [a, b]
            i = a
            found_multiple = False
            while i <= b:
                if i % c == 0:
                    found_multiple = True
                    break
                i += 1
            
            # The Java logic finds the first multiple starting from 'a'.
            # If the loop breaks, 'i' is that multiple.
            # If the loop finishes without finding a multiple, 'i' will be b + 1.
            
            # Replicating the Java loop structure for finding i:
            i = a
            while i <= b:
                if i % c == 0:
                    break
                i += 1
            
            # i