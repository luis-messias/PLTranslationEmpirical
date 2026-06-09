import sys

def nint():
    return int(input())

def nlong():
    return int(input())

class Main:
    def __init__(self):
        self.N = nint()
        self.W = nint()

        # 品物i
        self.v = [0] * (self.N + 1)
        self.w = [0] * (self.N + 1)

        for i in range(1, self.N + 1):
            self.v[i] = nint()
            self.w[i] = nint()

    def solve(self):
        sumV = [[0] * (self.W + 1) for _ in range(self.N + 1)]

        for i in range(1, self.N + 1):
            for i_sum in range(self.w[i]):
                sumV[i][i_sum] = sumV[i-1][i_sum]
            
            for i_sum in range(self.w[i], self.W + 1):
                sumV[i][i_sum] = max(sumV[i-1][i_sum], sumV[i-1][i_sum-self.w[i]] + self.v[i])

        print(sumV[self.N][self.W])

if __name__ == "__main__":
    main = Main()
    main.solve()