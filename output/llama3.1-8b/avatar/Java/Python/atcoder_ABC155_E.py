import sys

INF = 1e15

number = input()
digits = [0] * (len(number) + 1)
for i in range(len(number)):
    digits[i] = int(number[-1 - i])

bills = 0
for i in range(len(number) + 1):
    if digits[i] == 10:
        digits[i + 1] += 1
        digits[i] = 0
    if digits[i] < 5:
        bills += digits[i]
    elif digits[i] == 5:
        if digits[i + 1] >= 5:
            digits[i + 1] += 1
        bills += 5
    else:
        digits[i + 1] += 1
        bills += 10 - digits[i]

print(bills)