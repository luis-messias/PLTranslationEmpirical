import sys

VP = float(input())
VD = float(input())
T = float(input())
F = float(input())
C = float(input())

if VD <= VP:
    print(0)
else:
    start = T
    answer = 0
    while True:
        x = (start * VP) / (VD - VP)
        if ((start + x) * VP >= C):
            break
        start += 2 * x + F
        answer += 1
    print(answer)