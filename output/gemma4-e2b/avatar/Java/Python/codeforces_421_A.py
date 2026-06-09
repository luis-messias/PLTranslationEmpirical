import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        # n, a, b are the first three tokens
        n = int(data[0])
        a = int(data[1])
        b = int(data[2])
        
        # list1 contains the next 'a' elements
        list1 = [int(x) for x in data[3 : 3 + a]]
        
        # list2 contains the next 'b' elements (read but unused in the logic)
        #