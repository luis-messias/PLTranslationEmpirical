import sys

while True:
    try:
        s = sys.stdin.readline().strip()
        if not s:
            continue
            
        if s == "0":
            break
            
        sum_digits = 0
        for char in s:
            sum_digits += int(char)
            
        print(sum_digits)
    except EOFError:
        break