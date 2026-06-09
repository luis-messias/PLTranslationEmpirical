import sys

class Main:
    def __init__(self):
        self.score = []
        self.number = 0

    def main(self):
        while True:
            if not self.read():
                break
            self.slove()

    def read(self):
        try:
            self.number = int(input())
            if self.number == 0:
                return False
            for _ in range(self.number):
                self.score.append(int(input()))
            return True
        except ValueError:
            print("Invalid input. Please enter a valid integer.")
            return False

    def slove(self):
        self.score.sort()
        sum = 0
        for i in range(1, self.number-1):
            sum += self.score[i]
        print(int(sum/(self.number-2)))

if __name__ == "__main__":
    main = Main()
    main.main()
