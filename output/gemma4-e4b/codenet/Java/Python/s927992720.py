import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    
    if not data:
        return

    i = 0
    while i < len(data):
        try:
            # Read a, op, b
            a = int(data[i])
            op = data[i+1]
            b = int(data[i+2])
        except IndexError:
            break

        if op == "?":
            break
        
        if op == "+":
            print(a + b)
        elif op == "-":
            print(a - b)
        elif op == "*":
            print(a * b)
        elif op == "/":
            # Using integer division // to mimic Java's integer division
            print(a // b)
        
        i += 3

solve()