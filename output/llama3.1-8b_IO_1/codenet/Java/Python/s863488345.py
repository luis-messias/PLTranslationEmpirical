import sys

class Main:
    map_num = 0
    h = 0
    w = 0
    battle_town = []
    bomber_act_num = 0
    bomber_act = []

    def __init__(self):
        self.tank = [0, 0]
        self.x_of_tank = 0
        self.y_of_tank = 0
        self.x_of_bomber = 0
        self.y_of_bomber = 0

    def main(self):
        scanner = Scanner(sys.stdin)
        self.map_num = scanner.next_int()

        for i in range(self.map_num):
            if 1 <= i and i < self.map_num:
                print()
            self.h = scanner.next_int()
            self.w = scanner.next_int()

            self.battle_town = [[' ' for _ in range(self.w)] for _ in range(self.h)]

            for j in range(self.h):
                char_array = list(scanner.next())
                for k in range(self.w):
                    self.battle_town[j][k] = char_array[k]

                    if '^' == self.battle_town[j][k] or 'v' == self.battle_town[j][k] or '<' == self.battle_town[j][k] or '>' == self.battle_town[j][k]:
                        self.x_of_tank = j
                        self.y_of_tank = k

            self.bomber_act_num = scanner.next_int()
            self.bomber_act = list(scanner.next())

            if 0 <= self.x_of_tank and self.x_of_tank <= self.h and 0 <= self.y_of_tank and self.y_of_tank <= self.w:
                for l in range(self.bomber_act_num):
                    if self.bomber_act[l] == 'U':
                        self.battle_town[self.x_of_tank][self.y_of_tank] = '^'
                        if self.x_of_tank - 1 >= 0 and self.battle_town[self.x_of_tank - 1][self.y_of_tank] == '.':
                            self.battle_town[self.x_of_tank - 1][self.y_of_tank] = '^'
                            self.battle_town[self.x_of_tank][self.y_of_tank] = '.'
                            self.x_of_tank -= 1
                    if self.bomber_act[l] == 'D':
                        self.battle_town[self.x_of_tank][self.y_of_tank] = 'v'
                        if self.x_of_tank + 1 < self.h and self.battle_town[self.x_of_tank + 1][self.y_of_tank] == '.':
                            self.battle_town[self.x_of_tank + 1][self.y_of_tank] = 'v'
                            self.battle_town[self.x_of_tank][self.y_of_tank] = '.'
                            self.x_of_tank += 1
                    if self.bomber_act[l] == 'L':
                        self.battle_town[self.x_of_tank][self.y_of_tank] = '<'
                        if self.y_of_tank - 1 >= 0 and self.battle_town[self.x_of_tank][self.y_of_tank - 1] == '.':
                            self.battle_town[self.x_of_tank][self.y_of_tank - 1] = '<'
                            self.battle_town[self.x_of_tank][self.y_of_tank] = '.'
                            self.y_of_tank -= 1
                    if self.bomber_act[l] == 'R':
                        self.battle_town[self.x_of_tank][self.y_of_tank] = '>'
                        if self.y_of_tank + 1 < self.w and self.battle_town[self.x_of_tank][self.y_of_tank + 1] == '.':
                            self.battle_town[self.x_of_tank][self.y_of_tank + 1] = '>'
                            self.battle_town[self.x_of_tank][self.y_of_tank] = '.'
                            self.y_of_tank += 1
                    if self.bomber_act[l] == 'S':
                        self.x_of_bomber = self.x_of_tank
                        self.y_of_bomber = self.y_of_tank
                        self.move_bomber(self.x_of_bomber, self.y_of_bomber)

                for s in range(self.h):
                    for k in range(self.w):
                        print(self.battle_town[s][k], end='')
                    print()

class Scanner:
    def __init__(self, stream):
        self.stream = stream

    def next_int(self):
        return int(next(self.stream))

    def next(self):
        return next(self.stream)

def move_bomber(a, b):
    if 0 <= a and a <= Main.h and 0 <= b and b <= Main.w:
        if '^' == Main.battle_town[a][b]:
            for i in range(a - 1, -1, -1):
                if Main.battle_town[i][b] == '*':
                    Main.battle_town[i][b] = '.'
                    return
                elif Main.battle_town[i][b] == '#':
                    return
        if 'v' == Main.battle_town[a][b]:
            for i in range(a + 1, Main.h):
                if Main.battle_town[i][b] == '*':
                    Main.battle_town[i][b] = '.'
                    return
                elif Main.battle_town[i][b] == '#':
                    return
        if '<' == Main.battle_town[a][b]:
            for i in range(b - 1, -1, -1):
                if Main.battle_town[a][i] == '*':
                    Main.battle_town[a][i] = '.'
                    return
                elif Main.battle_town[a][i] == '#':
                    return
        if '>' == Main.battle_town[a][b]:
            for i in range(b + 1, Main.w):
                if Main.battle_town[a][i] == '*':
                    Main.battle_town[a][i] = '.'
                    return
                elif Main.battle_town[a][i] == '#':
                    return

if __name__ == "__main__":
    main = Main()
    main.main()
