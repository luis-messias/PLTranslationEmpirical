import sys

n = int(input())
a = [0] * (n + 2)
b = [0] * (n + 2)
num = [0] * (n + 2)

for i in range(1, n + 1):
    a[i] = int(input())

for i in range(1, n + 1):
    b[i] = int(input())

for i in range(1, n + 1):
    num[b[i]] += 1

ss = ""
ans = 0
st = [False] * (n + 2)

for i in range(1, n + 1):
    if a[i] == 1:
        st[i] = True
        sb = []
        x = b[i]
        sss = str(i)
        sb.append(sss[::-1])
        s = 1
        while not st[x] and num[x] == 1 and x != 0 and a[x] != 1:
            sss = str(x)
            sb.append(sss[::-1])
            st[x] = True
            x = b[x]
            s += 1
        if s > ans:
            ans = s
            ss = ''.join(sb[::-1])

print(ans)
print(ss)
