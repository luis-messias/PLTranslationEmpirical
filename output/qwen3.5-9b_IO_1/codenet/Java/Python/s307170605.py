import sys

input_data = sys.stdin.read().split()
for i, num in enumerate(input_data):
    if int(num) == 0:
        print(i + 1)
        break
