import sys

def solve():
    # Read all lines of input
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # The first element is n
    try:
        n = int(input_data[0])
    except ValueError:
        return

    # The remaining elements are grouped in sets of 3
    data_index = 1
    
    for i in range(n):
        if data_index + 2 >= len(input_data):
            break
            
        try:
            # Read three numbers for the current iteration
            a = [
                int(input_data[data_index]),
                int(input_data[data_index + 1]),
                int(input_data[data_index + 2])
            ]
            data_index += 3
        except ValueError:
            # Handle case where input might be malformed
            break

        # Sort the list
        a.sort()
        
        # Check Pythagorean theorem: c^2 = a^2 + b^2
        # a[2] is the largest (hypotenuse), a[0] and a[1] are the legs.
        if a[2]**2 == a[0]**2 + a[1]**2:
            print("YES")
        else:
            print("NO")

solve()