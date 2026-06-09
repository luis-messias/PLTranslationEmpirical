while True:
    line = input().split()
    if len(line) < 3:
        break
    a = int(line[0])
    op = line[1]
    b = int(line[2])
    
    if op == "?":
        break
    if op == "+":
        print(a + b)
    elif op == "-":
        print(a - b)
    elif op == "*":
        print(a * b)
    elif op == "/":
        print(a // b)
