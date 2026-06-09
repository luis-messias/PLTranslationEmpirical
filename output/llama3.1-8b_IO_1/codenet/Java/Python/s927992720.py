import sys

sc = iter(input, None)

while True:
    try:
        a = next(sc)
        op = next(sc)
        b = next(sc)
        
        if op == "?":
            break
        elif op == "+":
            print(int(a) + int(b))
        elif op == "-":
            print(int(a) - int(b))
        elif op == "*":
            print(int(a) * int(b))
        elif op == "/":
            print(int(a) // int(b))
    except StopIteration:
        break
