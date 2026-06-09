import sys

def main():
    n = int(input())
    min_n = int(input()) - 1
    for _ in range(n-1):
        h = input().split()[0]
        if min_n == h:
            min_n = h
        elif min_n == int(h)-1:
            min_n = int(h)-1
        elif min_n < int(h)-1:
            min_n = int(h)-1
        else:
            print("No")
            return
    print("Yes")

if __name__ == "__main__":
    main()
