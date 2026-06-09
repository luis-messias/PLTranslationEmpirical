import sys

sum = 0
while True:
    line = input()
    if not line or (line and int(line) == 0):
        break
    for a in map(int, filter(str.isdigit, line)):
        sum += a - '0'
    print(sum)