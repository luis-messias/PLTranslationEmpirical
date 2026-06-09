import sys

def main():
    s = list(input())
    t = list(input())
    check = False
    for i in range(len(s) - len(t) + 1):
        match = True
        for j, c in enumerate(s[i:i+len(t)]):
            if c != '?' and c != t[j]:
                match = False
                break
        if match:
            s[i:i+len(t)] = t
            check = True
            break
    if check:
        result = []
        for c in s:
            if c == '?':
                result.append('a')
            else:
                result.append(c)
        print(''.join(result))
    else:
        print("UNRESTORABLE")

if __name__ == "__main__":
    main()
