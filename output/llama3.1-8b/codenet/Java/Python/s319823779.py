import sys
def main():
    a = int(input())
    b = int(input())
    c = int(input())
    x = int(input())

    res = 0
    for i in range(a + 1):
        for j in range(b + 1):
            for k in range(c + 1):
                total = 500 * i + 100 * j + 50 * k
                if total == x:
                    res += 1

    print(res)

if __name__ == "__main__":
    main()