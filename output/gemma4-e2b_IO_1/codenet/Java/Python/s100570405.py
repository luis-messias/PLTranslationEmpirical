import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.readlines()
    
    if len(input_data) < 2:
        # Not enough input to proceed
        print("UNRESTORABLE")
        return

    Sd = input_data[0].strip()
    T = input_data[1].strip()

    if not Sd or not T:
        print("UNRESTORABLE")
        return

    n_s = len(Sd)
    n_t = len(T)
    
    first = -1
