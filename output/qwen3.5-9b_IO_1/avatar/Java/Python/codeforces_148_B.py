import sys

VP = int(sys.stdin.readline())
VD = int(sys.stdin.readline())
T = int(sys.stdin.readline())
F = int(sys.stdin.readline())
C = int(sys.stdin.readline())

if VD <= VP:
    print(0)
else:
    answer = 0
    start = T
    while True:
        x = start * VP / (VD - VP)
        if (start + x) * VP >= C:
            break
        start += 2 * x + F
        answer += 1
    print(answer)
