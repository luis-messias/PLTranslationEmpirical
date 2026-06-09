n = int(input())
c, flg = 0, 0

while n > 0:
    x = int(input())
    y = int(input())

    if x == y:
        c += 1
        if c >= 3:
            flg = 1
    else:
        c = 0
    
    n -= 1

if not flg:
    print("No")
else:
    print("Yes")