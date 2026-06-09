s = input().split(':')
t = input().split(':')

h1, m1 = int(s[0]), int(s[1])
h2, m2 = int(t[0]), int(t[1])

diff_hours = h1 - h2
diff_minutes = m1 - m2

if diff_minutes < 0:
    diff_hours -= 1
    diff_minutes += 60

print(f"{diff_hours:02}:{diff_minutes:02}")
