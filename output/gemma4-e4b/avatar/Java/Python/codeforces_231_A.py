import sys

def solve():
    data = sys.stdin.read().split()
    if not data:
        return

    t = int(data[0])
    count = 0
    data_index = 1

    for _ in range(t):
        a = int(data[data_index])
        b = int(data[data_index + 1])
        c = int(data[data_index + 2])
        data_index += 3

        # The condition checks if at least two of a, b, c are 1.
        # This is equivalent to the original Java condition:
        if (a == 1 and b == 1) or \
           (a == 1 and c == 1) or \
           (b == 1 and c == 1) or \
           (a == 1 and b == 1 and c == 1):
            count += 1

    print(