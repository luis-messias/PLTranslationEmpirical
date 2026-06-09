import sys

class FastReader:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        while not hasattr(self, 'st') or not self.st:
            try:
                self.st = self.br.readline().split()
            except Exception as e:
                print(e)
        return self.st.pop(0)

    def nextInt(self):
        return int(self.next())

class atcoder_AGC046_A:
    @staticmethod
    def main():
        sc = FastReader()
        x = sc.nextInt()
        count = 0
        tmp = x
        while True:
            x += tmp
            if x > 360:
                x -= 360
            count += 1
            if x == 360 or (x - 360) % 360 == 0:
                break

        print(count)

if __name__ == "__main__":
    atcoder_AGC046_A.main()
