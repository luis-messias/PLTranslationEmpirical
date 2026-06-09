def rotate(s):
    if len(s) == 0:
        return s
    return s[1:] + s[0]

s = input().strip()
t = input().strip()

flag = False
for _ in range(len(s)):
    s = rotate(s)
    if s == t:
        flag = True
        break

if flag:
    print("Yes")
else:
    print("No")
