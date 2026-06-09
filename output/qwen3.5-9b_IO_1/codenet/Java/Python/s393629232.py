import sys

def main():
    sc = sys.stdin
    n = int(sc.readline())
    minv = int(sc.readline())
    maxv = float('-inf')
    for _ in range(n - 1):
        ri = int(sc.readline())
        maxv = max(maxv, ri - minv)
        minv = min(minv, ri)
    print(maxv)

if __name__ == "__main__":
    main()
