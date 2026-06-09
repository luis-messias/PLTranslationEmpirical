import sys

def main():
    sc = sys.stdin
    a = next(sc).split()[0]
    b = int(next(sc))
    
    hb = b // 2
    
    print(int(a) + hb)

if __name__ == "__main__":
    main()
