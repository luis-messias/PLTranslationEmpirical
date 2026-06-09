import sys
from typing import List

class Atcoder_ABC112_A:
    def __init__(self):
        self.br = None

    def main(self):
        n = int(input())
        if n == 1:
            print("Hello World")
        else:
            strs = input().split()
            print(int(strs[0]) + int(strs[1]))

    def read(self, len):
        str_list = []
        try:
            if self.br is None:
                self.br = sys.stdin
            for _ in range(len):
                str_list.append(input())
        except Exception as e:
            pass
        return str_list

if __name__ == "__main__":
    solver = Atcoder_ABC112_A()
    solver.main()