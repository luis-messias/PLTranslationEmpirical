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

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

class codeforces_272_B:
    @staticmethod
    def rec(x):
        answer = 0
        for k in range(31, -1, -1):
            if (x & (1 << k)) != 0:
                answer += 1
        return answer

    @staticmethod
    def main():
        sc = FastReader()
        out = sys.stdout
        n = sc.nextInt()
        a = [0] * 33
        for i in range(n):
            a[Codeforces_272_B.rec(sc.nextInt())] += 1
        answer = 0
        for i in range(len(a)):
            summ = (a[i] - 1) / 2.0 * a[i]
            answer += summ
        print(int(answer))
        out.close()

if __name__ == "__main__":
    codeforces_272_B.main()