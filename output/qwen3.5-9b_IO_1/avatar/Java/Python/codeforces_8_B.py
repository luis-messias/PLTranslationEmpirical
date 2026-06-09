import sys

def main():
    s = sys.stdin.read().strip()
    x, y = 0, 0
    k = 0
    co = [[0] * 101, [0] * 101]
    co[0][k] = x
    co[1][k] = y
    k += 1
    
    for char in s:
        if char == 'L':
            x -= 1
        elif char == 'R':
            x += 1
        elif char == 'U':
            y += 1
        elif char == 'D':
            y -= 1
        co[0][k] = x
        co[1][k] = y
        k += 1
    
    flag = True
    for i in range(k - 3):
        for j in range(i + 3, k):
            dx = abs(co[0][i] - co[0][j])
            dy = abs(co[1][i] - co[1][j])
            if (dx <= 1 and dy == 0) or (dy <= 1 and dx == 0):
                flag = False
                break
        if not flag:
            break
    
    if flag:
        print("OK")
    else:
        print("BUG")

if __name__ == "__main__":
    main()
