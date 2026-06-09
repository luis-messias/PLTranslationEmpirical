import sys
from typing import TextIO, TextIOWrapper

def main():
    input_stream = sys.stdin
    output_stream = sys.stdout
    in_ = input_stream
    out = TextIOWrapper(output_stream, write_through=True)

    solver = AStationAndBus()
    solver.solve(1, in_, out)
    out.close()

class AStationAndBus:
    def solve(self, test_number: int, in_: TextIO, out: TextIOWrapper):
        s = in_.readline().strip()
        if "A" in s and "B" in s:
            out.write("Yes\n")
        else:
            out.write("No\n")

if __name__ == "__main__":
    main()