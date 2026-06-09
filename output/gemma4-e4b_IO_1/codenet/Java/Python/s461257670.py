import sys

def answer(y, m, d):
    result = 1

    # Initial calculation
    if y % 3 == 0:
        result += 20 - d
    elif m % 2 == 0:
        result += 19 - d
    else:
        result += 20 - d

    # Loop 1: m+=1 to 10 (inclusive)
    # The loop runs from m+1 up to 10.
    for current_m in range(m + 1, 11):
        if y % 3 == 0:
            result += 20
        else:
            if current_m % 2 == 0:
                result += 19
            else:
                result += 20

    # Loop 2: y += 1 to 999 (inclusive)
    # The loop runs from y+1 up to 999.
    for current_y in range(y + 1, 1000):
        if current_y % 3 == 0:
            result += 200
        else:
