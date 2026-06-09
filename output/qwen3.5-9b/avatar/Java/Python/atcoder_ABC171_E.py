import sys

def main():
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))
    r = 0
    for x in a:
        r ^= x
    
    for i in range(n):
        if i != 0:
            print(" ", end="")
        print(r ^ a[i], end="")
    print()

if __name__ == "__main__":
    main()