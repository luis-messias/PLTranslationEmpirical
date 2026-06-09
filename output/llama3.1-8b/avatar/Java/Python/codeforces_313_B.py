import sys

class Fast:
    def sol(self, br):
        s = next(br).strip()
        cum = [0] * (len(s) + 1)
        cum[0] = cum[-1] = 0
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                cum[i] = cum[i - 1] + 1
            else:
                cum[i] = cum[i - 1]
        
        while True:
            try:
                l, r = map(int, next(br).split())
                print(cum[r] - cum[l - 1])
            except StopIteration:
                break

if __name__ == "__main__":
    br = sys.stdin
    Fast().sol(br)