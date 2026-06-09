import sys

for i in range(5):
    num = int(sys.stdin.readline().strip())
    if num == 0:
        print(i + 1)
        break