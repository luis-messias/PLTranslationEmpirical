import sys

mapNum = int(input())
h, w = map(int, input().split())

battleTown = [input() for _ in range(h)]

xOfTank, yOfTank = -1, -1
aOfBomber, bOfBomber = 0, 0
s, k = ' ', ' '

for i in range(mapNum):
    if not (i + 1) < mapNum:
        print()
    
    h, w = map(int, input().split())
    battleTown = [input() for _ in range(h)]

    bomberActNum = int(input())

    tankDirection = {'^', 'v', '<', '>'}
    tankAction = {'U', 'D', 'L', 'R', 'S'}

    xOfTank, yOfTank = -1, -1
    aOfBomber, bOfBomber = 0, 0

    for j in range(h):
        c = input().strip()
        if any(c[i] == tankDirection[direction] for direction in ('^', 'v', '<', '>'):
            x, y = i, c.index(tankDirection[c[j]])
        
        bomberActNum = int(input())
        fighterAction = list(map(str, input().split())

        for l in range(bomberActNum):
            if fighterAction[l] == 'U':
                if 0 <= j and (j + 1) < h:
                    battleTown[(j - 1)][y], xOfBomber, bOfBomber = y, c.index(tankDirection[c[j]), i
            elif fighterAction[l] == 'D':
                if 0 <= j and (j + 1) < h:
                    battleTown[x][(j + 1)], xOfBomber, bOfBomber = y, c.index(tankDirection[c[j]], i
            elif fighterAction[l] == 'L':
                if 0 <= y and (y - 1) >= 0:
                    battleTown[x][(y - 1)], aOfBomber, bOfBomber = j, x, c.index(tankDirection[c[i]]
            elif fighterAction[l] == 'R':
                if 0 <= y and (y + 1) < w:
                    battleTown[(x)][(y + 1)], aOfBomber, bOfBomber = j, i
            elif fighterAction[l] == 'S':
                xOfBomber, bOfBomber = j, c.index(tankDirection[c[j]]
        for s in range(h):
            print(''.join(battleTown[s]), end='')