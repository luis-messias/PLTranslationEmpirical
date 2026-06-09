import sys
def main():
    str_in = input().split()
    h, a = int(str_in[0]), int(str_in[1])
    num = 0
    while h > 0:
        h -= a
        num += 1
    print(num)

if __name__ == "__main__":
    main()