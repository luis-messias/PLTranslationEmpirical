import sys

def main():
    s = input()
    x, y = 0, 0
    k = 0
    co = [[x, y] for _ in range(101)]
    for c in s:
        if c == 'L':
            x -= 1
        elif c == 'R':
            x += 1
        elif c == 'U':
            y += 1
        elif c == 'D':
            y -= 1
        co[k] = [x, y]
        k += 1

    for i in range(k - 3):
        for j in range(i + 3, k):
            dx = abs(co[i][0] - co[j][0])
            dy = abs(co[i][1] - co[j][1])
            if (dx <= 1 and dy == 0) or (dy <= 1 and dx == 0):
                print("BUG")
                return
    print("OK")

if __name__ == "__main__":
    main()