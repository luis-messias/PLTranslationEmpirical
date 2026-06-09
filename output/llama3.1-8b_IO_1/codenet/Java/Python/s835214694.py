import sys

def main():
    sc = sys.stdin
    a = next((x for x in sc.readline().split() if x.isdigit()), None)
    b = next((x for x in sc.readline().split() if x.isdigit()), None)

    if int(b) % int(a) == 0:
        print(int(a) + int(b))
    else:
        print(int(b) - int(a))

if __name__ == "__main__":
    main()
