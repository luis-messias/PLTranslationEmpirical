import sys

def solve():
    # Read the input string N
    try:
        N = sys.stdin.readline().strip()
    except EOFError:
        return
    
    if not N:
        return

    # Define the sets based on the Java code
    ODD = {"R", "U", "D"}
    EVE = {"L", "U", "D"}

    is_good = True
    
    # Iterate through the string N. i is the 0-based index.
    for i in range(len(N)):
        # k = i + 1 is the 1-based index
        k = i + 1
        
        current_char = N[i]
        
        # Java logic:
        # if ((i + 1) % 2 == 0) -> k is even -> check against EVE
        # else -> k is odd -> check against ODD
        
        if k % 2 == 0:
            # k is even, check against EVE
            if current_char not in EVE:
                is_good = False
                break
        else:
            # k is odd, check against ODD
            if current_char not in ODD:
                is_good = False
                break

    if is_good:
        print("Yes")
    else:
        print("No")

solve()