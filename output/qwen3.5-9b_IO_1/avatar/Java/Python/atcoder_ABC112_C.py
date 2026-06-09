import sys

def check(n, x, y, h, cx, cy):
    ch = -1
    for i in range(n):
        if h[i] > 0:
            ch = abs(x[i] - cx) + abs(y[i] - cy) + h[i]
            break
    
    for i in range(n):
        if h[i] != max(ch - abs(x[i] - cx) - abs(y[i] - cy), 0):
            return -1
    
    return ch

def main():
    n = int(input())
    x = []
    y = []
    h = []
    for _ in range(n):
        coords = list(map(int, input().split()))
        x.append(coords[0])
        y.append(coords[1])
        h.append(coords[2])
    
    for i in range(101):
        for j in range(101):
            ch = check(n, x, y, h, i, j)
            if ch > 0:
                print(i, j, ch)

if __name__ == "__main__":
    main()
