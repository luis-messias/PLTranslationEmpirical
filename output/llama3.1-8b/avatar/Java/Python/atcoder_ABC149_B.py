import sys

class atcoder_ABC149_B:
    def __init__(self):
        self.A = 0
        self.B = 0
        self.K = 0
        self.x = 0
        self.y = 0

    def calc(self):
        self.x = self.A
        self.y = self.B
        self.x = self.A - self.K
        if self.x < 0:
            self.y += self.x
            self.x = 0
            if self.y < 0:
                self.y = 0

    def showResult(self):
        print(f"{self.x} {self.y}")

if __name__ == "__main__":
    ins = atcoder_ABC149_B()
    tokens = input().split(" ")
    ins.A = int(tokens[0])
    ins.B = int(tokens[1])
    ins.K = int(tokens[2])
    ins.calc()
    ins.showResult()