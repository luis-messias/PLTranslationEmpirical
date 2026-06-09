import sys

class Codeforces67B:
    def __init__(self):
        self.sc = input()

    def main(self):
        n, k = map(int, self.sc.split())
        bb = list(map(int, self.sc.split()))
        aa = [0] * n
        m = 0
        for a in range(n-1, -1, -1):
            j = 0
            while bb[a] > 0:
                if aa[j] >= a + k:
                    bb[a] -= 1
                j += 1
            for j_ in range(m, j, -1):
                aa[j_] = aa[j_-1]
            aa[j] = a
            m = max(m, j)
        print(*[str(x+1) for x in aa], sep=' ')

if __name__ == "__main__":
    o = Codeforces67B()
    o.main()