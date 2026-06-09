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

    # First loop (m += 1 to 10)
    # The loop runs from m+1 up to and including 10.
    for current_m in range(m + 1, 11):
        if y % 3 == 0:
            result += 20
        else:
            if current