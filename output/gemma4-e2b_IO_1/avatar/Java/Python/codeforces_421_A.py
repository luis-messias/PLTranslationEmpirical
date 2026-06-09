import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # n, a, b are the first three tokens
    n = int(data[0])
    a = int(data[1])
    b = int(data[2])
    
    # list1 contains the next 'a' elements
    # These elements start at index 3
    list1 = [int(x) for x in data[3 : 3 + a]]
    
    # list2 contains the next 'b' elements (read but unused in the logic)
    # list2 = [int(x) for x in data[3 + a : 3 + a + b]]
    
    # Check numbers 1 to n against list1
    output = []
    for i in range(1, n + 1):
        # Check if i is present in list1
        if i in list1:
            output.append("1")
        else:
            output.append("2")
            
    # Print the results separated by spaces
    print(" ".join(output))

solve()
