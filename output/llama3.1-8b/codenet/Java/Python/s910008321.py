import math

def main():
    h = int(input())
    a = int(input())
    if h % a == 0:
        print(h // a)
    else:
        print((h + a - 1) // a)

if __name__ == "__main__":
    main()