import sys

def solve():
    # Read all input data from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        return

    # The remaining elements are the list contents
    if len(input_data) < n + 1:
        return
        
    list_data = [int(x) for x in input_data[1:n+1]]

    # Sort the list
    list_data.sort()

    # Initialize c
    c = 1

    # Iterate through the sorted list and update c
    for element in list_data:
        if element >= c:
            c += 1

    # Print the result
    print(c)

if __name__ == "__main__":
    solve()