import sys
from bisect import bisect_left
import math

class LightScanner:
    def __init__(self, in_stream):
        self.reader = in_stream

    def string(self):
        if not hasattr(self, 'tokenizer') or not self.tokenizer:
            try:
                self.tokenizer = self.reader.readline().split()
            except Exception as e:
                raise Exception(str(e))
        return self.tokenizer.pop(0)

    def ints(self):
        return int(self.string())

    def longs(self):
        return int(self.string())

class LightWriter:
    def __init__(self, out_stream):
        self.out = out_stream
        self.autoflush = False

    def print(self, c):
        try:
            self.out.write(c)
        except Exception as e:
            raise Exception(str(e))

    def print(self, s):
        try:
            self.out.write(s)
        except Exception as e:
            raise Exception(str(e))

    def ans(self, s):
        if hasattr(self, 'breaked') and not self.breaked:
            self.print(' ')
        return self.print(s)

    def ansln(self, *n):
        for i in n:
            self.ans(i).ln()
        return self

    def ln(self):
        try:
            self.out.write('\n')
            self.breaked = True
            if self.autoflush:
                self.out.flush()
        except Exception as e:
            raise Exception(str(e))
        return self

    def close(self):
        try:
            self.out.close()
        except Exception as e:
            raise Exception(str(e))

class DLazyFaith:
    def solve(self, test_number, in_stream, out_stream):
        a = in_stream.ints()
        b = in_stream.ints()
        q = in_stream.ints()

        s = [-10**18] + [in_stream.longs() for _ in range(a)] + [20*10**9]
        t = [-10**18] + [in_stream.longs() for _ in range(b)] + [20*10**9]

        for i in range(q):
            x = in_stream.longs()
            sl = x - s[bisect_left(s, x+1) - 1]
            tl = x - t[bisect_left(t, x+1) - 1]
            sr = s[bisect_left(s, x)] - x
            tr = t[bisect_left(t, x)] - x

            out_stream.ansln(min(max(sl,tl), max(sr,tr), 2*sl + tr, 2*tl + sr, sl + 2*tr, tl + 2*sr))

def main():
    in_stream = sys.stdin
    out_stream = sys.stdout
    light_scanner = LightScanner(in_stream)
    light_writer = LightWriter(out_stream)

    dlazy_faith_solver = DLazyFaith()
    dlazy_faith_solver.solve(1, light_scanner, light_writer)
    light_writer.close()

if __name__ == "__main__":
    main()