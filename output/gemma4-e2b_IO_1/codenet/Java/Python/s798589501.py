import sys

try:
    # Read E and Y from standard input
    data = sys.stdin.read().split()
    if len(data) < 2:
        # Exit if input is insufficient
        exit()
    
    E = int(data[0])
    Y = int(data[1])

    if E == 0:
        if Y <= 1911:
            result = str(Y - 1867)
            print("M" + result)
        elif Y <= 1925:
            result = str(Y - 1911)
            print("T" + result)
        elif Y <= 1988:
            result = str(Y - 1925)
            print("S" + result)
        else:
            result = str(Y - 1988)
            print("H" + result)
            
    elif E == 1:
        print(1867 + Y)
    elif E == 2:
        print(1911 + Y)
    elif E == 3:
        print(1925 + Y)
    else:
        print(1988 + Y)

except Exception:
    # Handle potential errors
    pass
