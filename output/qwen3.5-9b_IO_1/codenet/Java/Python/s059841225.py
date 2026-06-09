import sys

def main():
    for line in sys.stdin:
        line = line.strip()
        if not line:
            continue
        strArr = line.split(',')
        l = [int(x) for x in strArr[:10]]
        d = sum(l)
        v = [int(strArr[10]), int(strArr[11])]
        t = d / (v[0] + v[1])
        d = 0
        for i in range(11):
            if v[0] * t <= d:
                print(i)
                break
            else:
                d += l[i]

if __name__ == "__main__":
    main()
