import math

while True:
    a = input()
    b = input()

    if not (a and b):
        break
    
    c = max(a, b)
    
    if a == c and not b or not a:
        print("EQUAL")
    elif b and not a:
        print("LESS")
    else: 
        print("GREATER" if a > b else "EQUAL")