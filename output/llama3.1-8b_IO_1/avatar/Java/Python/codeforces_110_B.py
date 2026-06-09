n = int(input())
c = [''] * n
p = 97

for i in range(4):
    for j in range(i, n, 4):
        c[j] = chr(p)
        p += 1

print(''.join(c))
