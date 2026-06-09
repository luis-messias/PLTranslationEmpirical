import sys

class IntegralRect:
    def __init__(self, h, w):
        self.height = h
        self.width = w

    def diagonal(self):
        if self.height >= self.width:
            return float('inf')
        return self.height**2 + self.width**2

    def compareTo(self, other):
        d1 = self.diagonal()
        d2 = other.diagonal()
        if d1 == d2:
            return self.height - other.height
        else:
            return d1 - d2


rects = []
for i in range(200):
    for j in range(200):
        rects.append(IntegralRect(i + 1, j + 1))
rects.sort(key=lambda x: x.diagonal())

while True:
    try:
        h, w = map(int, input().split())
        if h == 0 and w == 0:
            break
        tmp_rect = IntegralRect(h, w)
        for i in range(len(rects)):
            if rects[i].compareTo(tmp_rect) > 0:
                print(f"{rects[i].height} {rects[i].width}")
                break
    except ValueError:
        pass