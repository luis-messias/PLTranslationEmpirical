import re

def main():
    s = input().replace('?','')
    t = input()
    check = False
    for i in range(len(s) - len(t) + 1):
        if all(c == '?' or c == t[j] for j, c in enumerate(s[i:i+len(t)])):
            s = s[:i] + t + s[i+len(t):]
            check = True
            break
    if check:
        print(''.join('a' if c == '?' else c for c in s))
    else:
        print("UNRESTORABLE")

if __name__ == "__main__":
    main()