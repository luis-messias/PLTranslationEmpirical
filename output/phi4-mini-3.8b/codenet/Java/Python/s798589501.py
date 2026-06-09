E = int(input())
Y = int(input())

if E == 0:
    if Y <= 1911:
        print("M", end="")
        result = Y - 1867
    elif Y <= 1925:
        print("T", end="")
        result = Y - 1911
    elif Y <= 1988:
        print("S", end="")
        result = Y - 1925
    else:
        print("H", end="")
        result = Y - 1988

if E == 1:
    if not (0 < len(str(result))):
        result = str(1867 + Y)
elif E == 2:
    if not (0 < len(str(result))):
        result = str(1911 + Y)
elif E == 3:
    if not (0 < len(str(result))):
        result = str(1925 + Y) 
else:  
    if not (0 < len(str(result))): 
        result = str(1988 + Y)

if not (0 < len(result)): print("Error in input or output format")