import sys
from collections import Counter

def reverse(ch):
    if ch.islower():
        return ch.upper()
    else:
        return ch.lower()

def main():
    s = sys.stdin.readline().strip()
    t = sys.stdin.readline().strip()
    
    tmap = Counter(t)
    
    length = len(s)
    ura = 0
    
    for i in range(length):
        ch = s[i]
        if ch in tmap and tmap[ch] > 0:
            tmap[ch] -= 1
            s = s[:i] + 'Я' + s[i+1:]
            ura += 1
    
    opa = 0
    for i in range(length):
        ch = s[i]
        rch = reverse(ch)
        if rch in tmap and tmap[rch] > 0:
            tmap[rch] -= 1
            opa += 1
    
    print(ura, opa)

if __name__ == "__main__":
    main()
