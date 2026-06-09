import re

def rotate(s):
    return s[-1] + s[:-1]

def main():
    s = input()
    t = input()
    flag = False
    for _ in range(len(s)):
        s = rotate(s)
        if s == t:
            flag = True
            break
    print("Yes" if flag else "No")

if __name__ == "__main__":
    main()