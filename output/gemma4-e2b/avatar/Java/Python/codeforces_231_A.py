import sys

def solve():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        t = int(data[0])
    except ValueError:
        return

    count = 0
    data_ptr = 1

    for _ in range(t):
        if data_ptr + 2 < len(data):
            try:
                a = int(data[data_ptr])
                b = int(data[data_ptr + 1])
                c = int(data[data_ptr + 2])
                data_ptr += 3
            except ValueError:
                # Skip if conversion fails
                continue

            # The condition is met if at least two of a, b, c are equal to 1.
            # This is equivalent to checking if the sum of (a==1), (b==1), and (c==1) is >= 2.
            ones_count = (a == 1) + (b == 1) + (c == 1)
            
            if ones_count >= 2:
                count += 1
        else:
            break

    print(count)

solve()