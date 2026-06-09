import sys

scList = []
for line in sys.stdin:
    try:
        scList.append(line.strip())
    except Exception as e:
        break

numlist = scList[0].split()
Sheep, Wolve = map(int, numlist)

if Wolve >= Sheep:
    print("unsafe")
else:
    print("safe")