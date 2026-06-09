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

    def next_int(self):
        return int(self.next())

    def next_long(self):
        return int(self.next())

    def next_double(self):
        return float(self.next())

    def next_line(self):
        try:
            return self.br.readline().strip()
        except Exception as e:
            print(e)
            return ""

def mod_power(x, y, mod):
    res = 1
    x %= mod
    if x == 0:
        return 0
    while y > 0:
        if y % 2 == 1:
            res = (res * x) % mod
        y >>= 1
        x = (x * x) % mod
    return res

def main():
    in_ = FastReader()
    a = [in_.next_long() for _ in range(4)]
    print(max(a[0] * a[2], max(a[1] * a[3], max(a[0] * a[3], a[1] * a[2]))))

if __name__ == "__main__":
    main()