import sys

stack = []

for line in sys.stdin:
    try:
        a = int(line.strip())
        if a == 0:
            if stack:
                print(stack.pop())
        else:
            stack.append(a)
    except ValueError:
        break