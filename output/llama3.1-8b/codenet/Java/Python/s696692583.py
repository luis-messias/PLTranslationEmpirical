import sys

def tr(*os):
    print(deepToString(os))

class Main:
    def __init__(self):
        self.sc = Scanner()

    def run(self):
        while True:
            try:
                my1, my2, enemy1 = map(int, input().split())
                used = [False] * 11
                used[my1 - 1] = True
                used[my2 - 1] = True
                used[enemy1 - 1] = True

                all = 0
                safe = 0
                for i in range(1, 11):
                    if not used[i - 1]:
                        all += 1
                        if my1 + my2 + i <= 20:
                            safe += 1
                if safe * 2 >= all:
                    print("YES")
                else:
                    print("NO")
            except ValueError:
                break

    def solve(self, a):
        s = ['d', 'o', 'x']
        for side in range(1, 3):
            for i in range(3):
                if a[i][0] == side and a[i][1] == side and a[i][2] == side:
                    return s[side]
                if a[0][i] == side and a[1][i] == side and a[2][i] == side:
                    return s[side]
            if a[0][0] == side and a[1][1] == side and a[2][2] == side:
                return s[side]
            if a[0][2] == side and a[1][1] == side and a[2][0] == side:
                return s[side]
        return 'd'

class Scanner:
    def __init__(self):
        self.stdin = sys.stdin

    def next(self):
        return self.stdin.readline().strip()

    def hasNext(self):
        return True

if __name__ == "__main__":
    main = Main()
    main.run()