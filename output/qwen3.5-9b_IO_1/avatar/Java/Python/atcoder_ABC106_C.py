s = input()
k = int(input())
c = list(s)
for i in range(k):
    if c[i] == '1':
        if i == k - 1:
            print(1)
            break
    else:
        print(c[i])
        break
