import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except IndexError:
        return

    # Initialize variables
    temp = 0
    q = 0
    w = 0
    e = 0
    f = False

    # Process pairs (a[i], b[i])
    for i in range(n):
        # Input indices: 1 + 2*i for a[i], 2 + 2*i for b[i]
        try:
            a_i = int(input_data[1 + 2 * i])
            b_i = int(input_data[2 + 2 * i])
        except IndexError:
            # Handle case where input might be incomplete
            break

        # Block 1
        if temp < a_i:
            if q > b_i:
                f = True
            q = b_i
            temp = a_i

        # Block 2
        if temp > a_i:
            if q < b_i:
                f = True
            q = b_i
            temp = a_i

        # Block 3
        if a_i > w:
            w = a_i
            if b_i < e:
                f = True
            e = b_i

        # Block 4
        if a_i < w:
            if b_i > e:
                f = True

    if f:
        print("Happy Alex")
    else:
        print("Poor Alex")

if __name__ == "__main__":
    solve()