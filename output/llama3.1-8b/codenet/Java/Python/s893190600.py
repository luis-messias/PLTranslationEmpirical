import sys

class PP:
    def __init__(self, key, val):
        self.key = key
        self.val = val

    def get_key(self):
        return self.key

    def set_key(self, key):
        self.key = key

    def get_val(self):
        return self.val

    def set_val(self, val):
        self.val = val


class PPL:
    def __init__(self, key, val):
        self.key = key
        self.val = val

    def get_key(self):
        return self.key

    def set_key(self, key):
        self.key = key

    def get_val(self):
        return self.val

    def set_val(self, val):
        self.val = val


class PPDL:
    def __init__(self, key, val):
        self.key = key
        self.val = val

    def get_key(self):
        return self.key

    def set_key(self, key):
        self.key = key

    def get_val(self):
        return self.val

    def set_val(self, val):
        self.val = val


class MyInput:
    def __init__(self, is_):
        self.is_ = is_

    def read(self):
        if sys.stdin.readable():
            return sys.stdin.read(1)
        else:
            raise Exception("End of file")

    def next_int(self):
        ret = 0
        while True:
            c = self.read()
            if '0' <= c <= '9':
                ret = ret * 10 + ord(c) - ord('0')
            elif c == '-':
                sign = -1
            else:
                break
        return ret * sign

    def next_long(self):
        ret = 0
        while True:
            c = self.read()
            if '0' <= c <= '9':
                ret = ret * 10 + ord(c) - ord('0')
            elif c == '-':
                sign = -1
            else:
                break
        return ret * sign

    def next_double(self):
        ret = 0.0
        while True:
            c = self.read()
            if '0' <= c <= '9':
                ret = ret * 10 + ord(c) - ord('0')
            elif c == '.':
                continue
            elif c == '-':
                sign = -1
            else:
                break
        return ret * sign

    def next_string(self):
        while True:
            c = self.read()
            if ' ' <= c <= '~' or c == '\n':
                if c != '\n':
                    continue
                else:
                    break
            else:
                ret = ''
                while True:
                    ret += c
                    c = self.read()
                    if not (' ' <= c <= '~'):
                        break
                return ret


def main():
    my_input = MyInput(sys.stdin)
    n = my_input.next_int()
    arr = [my_input.next_long() for _ in range(n)]
    print(arr)


if __name__ == "__main__":
    main()