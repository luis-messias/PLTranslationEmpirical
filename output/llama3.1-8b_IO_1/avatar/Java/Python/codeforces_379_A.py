import sys

def main():
    a = int(sys.stdin.readline().split()[0])
    b = int(sys.stdin.readline().split()[0])
    res = a
    while a >= b:
        res += (a // b)
        a = (a // b) + (a % b)
    print(res)

if __name__ == "__main__":
    main()
