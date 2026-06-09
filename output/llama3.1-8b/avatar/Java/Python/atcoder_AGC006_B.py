import sys

def main():
    n = int(input())
    x = int(input())
    print(x, n)

def print_(x, n):
    max_ = 2 * n - 1
    if x == 1 or x == max_:
        print("No")
        return
    print("Yes")
    sep = "\n"
    ans = "".join(str((e % max_ + 1)) + sep for e in range(x + n - 1, x + n + max_))
    print(ans)

if __name__ == "__main__":
    main()