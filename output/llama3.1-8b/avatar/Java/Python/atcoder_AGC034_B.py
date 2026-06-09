import sys
from typing import TextIO, AnyStr

def main():
    input_stream = sys.stdin
    output_stream = sys.stdout
    in_ = input_stream
    out = output_stream

    solver = BABC()
    solver.solve(1, in_, out)

class BABC:
    def solve(self, test_number: int, in_: TextIO, out: AnyStr) -> None:
        s = in_.readline().replace("BC", "D")
        cnt = 0
        tmp = 0
        for i in range(len(s)):
            if s[i] == 'A':
                tmp += 1
            elif s[i] == 'D':
                cnt += tmp
            else:
                tmp = 0
        out.write(str(cnt) + "\n")

if __name__ == "__main__":
    main()