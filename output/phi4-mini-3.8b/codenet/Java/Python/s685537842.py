a = int(input())
b = int(input())
t = float(input())

count = 0
time = 0.0

while time < (t + 0.5):
    count += b
    time += a
    if time > (t + 0.5):
        break