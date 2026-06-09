import sys

class atcoder_ABC174_C:
    def __init__(self):
        self.br = sys.stdin
        self.pw = sys.stdout
        self.st = None

    def readInt(self):
        while self.st is None or not self.st:
            self.st = next(self.br).split()
        return int(self.st.pop(0))

    def main(self):
        K = self.readInt()
        if K % 2 == 0 or K % 5 == 0:
            return -1
        if K % 7 == 0:
            K //= 7
        K *= 9
        ans = 1
        remainder = 10 % K
        while remainder != 1:
            ans += 1
            remainder = (remainder * 10) % K
        return ans

if __name__ == "__main__":
    atcoder = atcoder_ABC174_C()
    print(atcoder.main())
