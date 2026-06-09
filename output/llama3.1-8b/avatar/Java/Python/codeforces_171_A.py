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

    def nextLine(self):
        try:
            return self.br.readline().strip()
        except Exception as e:
            print(e)
            return ""

def reverse(n):
    if n < 10:
        return n * 10
    t = n
    r = 0
    while t > 0:
        r = (r * 10) + t % 10
        t //= 10
    return r

if __name__ == "__main__":
    sc = FastReader()
    n = sc.nextInt()
    m = sc.nextInt()
    t = reverse(m)
    print(t + n)