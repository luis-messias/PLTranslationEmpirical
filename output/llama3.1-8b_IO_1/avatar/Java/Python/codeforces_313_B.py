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
        
        q = int(next(br))
        while q > 0:
            st = next(br).split()
            l, r = map(int, st)
            print(cum[r] - cum[l - 1])
            q -= 1

if __name__ == "__main__":
    br = sys.stdin
    Fast().sol(br)
