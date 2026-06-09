import math

def main():
    q = int(input())
    while q > 0:
        n = int(input())
        x = int(math.log(n, 2)) + 1
        s = -2**x + 2 + (n * (n + 1)) // 2 - 2**x
        print(s)
        q -= 1

if __name__ == "__main__":
    main()