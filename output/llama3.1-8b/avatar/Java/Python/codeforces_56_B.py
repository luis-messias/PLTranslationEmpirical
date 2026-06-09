import sys

def main():
    len_ = int(sys.stdin.readline())
    a = [int(x) for x in sys.stdin.readline().split()]
    l, r, flag, is_true = 0, 0, False, False

    for i in range(len_):
        if a[i] != i + 1 and not flag:
            l = i + 1
            flag = True
            continue
        if a[i] != i + 1 and flag:
            r = i + 1
            if (a[r - 1] - a[r - 2]) > 0:
                is_true = True
                break

    print(f"{l} {r}" if not is_true else "0 0")

if __name__ == "__main__":
    main()