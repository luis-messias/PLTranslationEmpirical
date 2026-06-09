import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N
    try:
        n = int(data[0])
    except IndexError:
        return

    ai = []
    bi = []
    
    # Process the remaining 2*N elements
    data_index = 1
    for i in range(n):
        try:
            a_val = int(data[data_index])
            b_val = int(data[data_index + 1])
            ai.append(a_val)
            bi.append(b_val)
            data_index += 2
        except IndexError:
            # Should not happen if input is correctly formatted
            break

    # Sort the arrays
    ai.sort()
    bi.sort()

    if n % 2 == 1:
        # Odd case: use the middle element
        mid_index = n // 2
        result = bi[mid_index] - ai[mid_index] + 1
        print(result)
    else:
        # Even case: use the average of the two middle elements
        
        # Indices are n/2 - 1 and n/2
        mid_right = n // 2
        mid_left = n // 2 - 1
        
        # Calculate b (average of two middle elements of ai)
        b = (ai[mid_right] + ai[mid_left]) / 2.0
        
        # Calculate c (average of two middle elements of bi)
        c = (bi[mid_right] + bi[mid_left]) / 2.0
        
        # Calculate the final result and cast to integer
        result = int(2 * (c - b) + 1)
        print(result)

if __name__ == "__main__":
    solve()