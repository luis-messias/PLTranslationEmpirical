n = int(input())
s = [".,!? :abc:def:ghi:jkl:mno:pqrs:tuv:wxyz"]
k = (''.join(s).split(':'))

while n > 0:
    c = input().strip()
    a = -1
    for i in range(len(c)):
        if not c[i] == '0':
            a = ord(c[i]) - ord('a')
            l = (l + 1) % len(k[a])
        elif a >= 0 and k:
            print(k[int(a)][int(l)]
            break
    n -= 1