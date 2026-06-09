import sys

class Codeforces67B:
    def __init__(self):
        self.sc = input().split()
        self.n = int(self.sc[0])
        self.k = int(self.sc[1])

    def main(self):
        bb = list(map(int, self.sc[2:]))
        aa = [0] * self.n
        m = 0
        for a in range(self.n-1, -1, -1):
            j = 0
            while j < len(bb) and bb[j] > 0:
                if aa[j] >= a + self.k:
                    bb[j] -= 1
                j += 1
            for j_ in range(m, j, -1):
                aa[j_] = aa[j_-1]
            aa[j] = a
            m = max(m, j)
        print(*[str(x+1) for x in aa], sep=' ')

if __name__ == "__main__":
    o = Codeforces67B()
    o.main()
