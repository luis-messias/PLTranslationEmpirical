import sys
from typing import NoSuchElementException

class MyInput:
    def __init__(self):
        self.in_ = sys.stdin.buffer
        self.buffer = bytearray(1024)
        self.ptr = 0
        self.buflen = 0

    def hasNextByte(self):
        if self.ptr < self.buflen:
            return True
        else:
            self.ptr = 0
            try:
                self.buflen = self.in_.readinto(self.buffer)
            except Exception as e:
                print(e, file=sys.stderr)
            if self.buflen <= 0:
                return False
        return True

    def readByte(self):
        if self.hasNextByte():
            return self.buffer[self.ptr]
        else:
            return -1

    @staticmethod
    def isPrintableChar(c):
        return 33 <= c <= 126

    def skipUnprintable(self):
        while self.hasNextByte() and not self.isPrintableChar(self.buffer[self.ptr]):
            self.ptr += 1

    def hasNext(self):
        self.skipUnprintable()
        return self.hasNextByte()

    def next(self):
        if not self.hasNext():
            raise NoSuchElementException
        sb = bytearray()
        b = self.readByte()
        while self.isPrintableChar(b):
            sb.append(b)
            try:
                b = self.readByte()
            except IndexError:
                break
        return bytes(sb).decode('utf-8')

    def nextLong(self):
        if not self.hasNext():
            raise NoSuchElementException
        n = 0
        minus = False
        b = self.readByte()
        if b == -1 or not self.isPrintableChar(b):
            return None
        if b == '-':
            minus = True
            try:
                b = self.readByte()
            except IndexError:
                break
        if not '0' <= b <= '9':
            raise ValueError
        while True:
            if '0' <= b <= '9':
                n *= 10
                n += b - '0'
            else:
                try:
                    b = self.readByte()
                except IndexError:
                    break
            if not self.isPrintableChar(b):
                return minus and -n or n

    def nextInt(self):
        nl = self.nextLong()
        if nl is None or (nl < -2**31 and nl > 2**31-1):
            raise ValueError
        return int(nl)

    def nextDouble(self):
        return float(self.next())

class Main:
    def run(self, in_):
        Sd = in_.next()
        T = in_.next()
        count = 0
        c
        ok = False
        first = -1
        end = -1
        for j in range(len(Sd)):
            count = 0
            for i in range(j, len(Sd)):
                c = Sd[i]
                if c == '?' or c == T[count]:
                    count += 1
                    if count == len(T):
                        first = i - len(T) + 1
                        end = i
                        ok = True
                        break
                else:
                    count = 0

        if ok:
            for i in range(len(Sd)):
                if first <= i <= end:
                    print(T[i - first], end='')
                elif Sd[i] == '?':
                    print('a', end='')
                else:
                    print(Sd[i], end='')
            print()
        else:
            print("UNRESTORABLE")

if __name__ == "__main__":
    in_ = MyInput()
    Main().run(in_)
