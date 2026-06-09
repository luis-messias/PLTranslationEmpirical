while True:
    s = input()
    if s == "0":
        break
    total = 0
    for char in s:
        total += int(char)
    print(total)
