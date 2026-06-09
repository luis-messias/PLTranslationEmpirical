import sys

def main():
    x = int(input())
    y = int(input())
    a = int(input())
    b = int(input())

    j = 2
    c = max(x, y)
    ans = True

    if c > b:
        print(0)
        ans = False

    while c % min(x, y) != 0 and ans:
        if x > y:
            c = x * j
        else:
            c = y * j
        j += 1
        if c > b:
            print(0)
            ans = False
            break

    if ans:
        count = 0
        i = a
        while True:
            if i % c == 0:
                break
            i += 1
        if i != b + 1:
            print((b - i) // c + 1)
        else:
            print(0)

if __name__ == "__main__":
    main()