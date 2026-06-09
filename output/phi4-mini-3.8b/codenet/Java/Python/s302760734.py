import sys

def main():
    s = list(sys.stdin.readline().strip())
    t = list(sys.stdin.readline().strip())

    check = False
    for i in range(len(s) - len(t), -1, -1):
        if all(c == '?' or c == ch for c, ch in zip(s[i:], t)):
            check = True
            s[i:] = [ch for ch in t]
            break

    if check:
        print(''.join(ch if ch != '?' else 'a' for ch in s))
    else:
        sys.stdout.write("UNRESTORABLE\n")

if __name__ == "__main__":
    main()