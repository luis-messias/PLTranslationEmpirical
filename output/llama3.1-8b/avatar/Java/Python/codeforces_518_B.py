from collections import defaultdict
import string

def main():
    s = input()
    t = input()
    ura = 0
    opa = 0
    tmap = defaultdict(int)
    for ch in t:
        tmap[ch] += 1

    length = len(s)
    for i in range(length):
        ch = s[i]
        if ch not in tmap:
            continue
        num = tmap[ch]
        if num == 1:
            del tmap[ch]
        else:
            tmap[ch] -= 1
        ura += 1

    for i in range(length):
        ch = s[i]
        rch = string.ascii_lowercase[string.ascii_uppercase.find(ch)] if ch.isupper() else string.ascii_uppercase[string.ascii_lowercase.find(ch)]
        num = tmap.get(rch)
        if num is None:
            continue
        inum = num
        if inum == 1:
            del tmap[rch]
        else:
            tmap[rch] -= 1
        opa += 1

    print(ura, opa)

if __name__ == "__main__":
    main()