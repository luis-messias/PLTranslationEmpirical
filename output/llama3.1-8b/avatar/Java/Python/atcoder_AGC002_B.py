import sys

class Box:
    def __init__(self, n, r):
        self.num = n
        self.red = r

    def move_to(self, other):
        if self.num == 0:
            return
        elif self.num == 1:
            self.num = 0
            other.num += 1
            if self.red:
                other.red = True
            self.red = False
        else:
            self.num -= 1
            other.num += 1
            if self.red:
                other.red = True

def main():
    N, M = map(int, input().split())
    B = [Box(1, True)] + [Box(1, False) for _ in range(N-1)]

    for _ in range(M):
        x, y = map(lambda s: int(s)-1, input().split())
        B[x].move_to(B[y])

    counter = sum(box.red for box in B)
    print(counter)

if __name__ == "__main__":
    main()