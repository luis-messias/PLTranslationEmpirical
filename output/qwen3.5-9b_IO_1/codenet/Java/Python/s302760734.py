s = input()
t = input()

check = False
for i in range(len(s) - len(t), -1, -1):
    check2 = True
    for j in range(len(t)):
        if s[i+j] != '?' and s[i+j] != t[j]:
            check2 = False
            break
    if check2:
        check = True
        s_list = list(s)
        for j in range(len(t)):
            s_list[i+j] = t[j]
        s = ''.join(s_list)
        break

if check:
    result = []
    for char in s:
        if char == '?':
            result.append('a')
        else:
            result.append(char)
    print(''.join(result))
else:
    print("UNRESTORABLE")
