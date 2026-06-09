def rotate(s):
    len_s = len(s)
    t = s[0]
    for i in range(len_S - 1):
        s[i] = s[i + 1]
    s[len_S - 1] = t

s, t = input(), input()
flag = False
for _ in range(4):  # Assuming a maximum of four rotations to check all possibilities.
    rotate(list(s))
    if ''.join(t) == ''.join(s):
        flag = True
        break
if flag:
    print("Yes")
else:
    print("No")