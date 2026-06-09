import sys

def solve(sc):
    line = sc.readline().strip()
    if len(line) < 3 or (line[0] == line[1]) or (line[1] == line[2]) or (line[2] == line[0]):
        print("No")
    else:
        print("Yes")

if __name__ == "__main__":
    solve(sys.stdin)