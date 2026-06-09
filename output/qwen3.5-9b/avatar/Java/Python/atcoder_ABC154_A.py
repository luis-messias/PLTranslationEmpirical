import sys

def main():
    s = input().split()
    a, b = map(int, input().split())
    u = input()
    if u == s[0]:
        print(f"{a-1} {b}")
    else:
        print(f"{a} {b-1}")

if __name__ == "__main__":
    main()