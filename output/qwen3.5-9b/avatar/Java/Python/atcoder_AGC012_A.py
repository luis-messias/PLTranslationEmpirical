import sys

def main():
    input = sys.stdin.read
    data = input().split()
    n = int(data[0])
    array = [int(x) for x in data[1:]]
    array.sort()
    head = len(array) - 2
    res = 0
    for _ in range(n):
        res += array[head]
        head -= 2
    print(res)

if __name__ == "__main__":
    main()