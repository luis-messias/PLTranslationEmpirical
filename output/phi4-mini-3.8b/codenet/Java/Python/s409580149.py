import sys
from functools import reduce

def plus(x, y):
    return x + y % mod

def sub(x, y):
    return (x - y) % mod

mod = 1000003


input_data = input().strip()
if not input_data:
    print(0)
else:

    def read():
        while True:
            c = sys.stdin.read(1)
            if len(c) == 0 or ord(c) < 33 and ord(c) > 126: 
                return -1
            yield c

def main():

    for _ in range(int(input_data)):
        x, y = map(int, read())
        print((plus(x, y), sub(x, y)))


if __name__ == "__main__":
    sys.setrecursionlimit(10**6)
    main()