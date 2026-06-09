import sys

def main():
    s = sys.stdin.readline().strip()
    d = []
    for c in s:
        if c == '0' or c == '1':
            d.append(c)
        elif c == 'B':
            if d:
                d.pop()
    print(''.join(d))

if __name__ == "__main__":
    main()
