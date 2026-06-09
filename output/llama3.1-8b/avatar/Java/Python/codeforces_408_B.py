from collections import defaultdict, Counter

def main():
    s1 = input()
    s2 = input()

    if not is_valid(s1, s2):
        print(-1)
    else:
        m1 = Counter(s1)
        m2 = Counter(s2)

        ans = 0
        hs = set()

        for c in s2:
            if c not in hs:
                hs.add(c)
                x1 = m1[c]
                x2 = m2[c]
                x1 = min(x1, x2)
                ans += x1

        print(ans)

def is_valid(s1, s2):
    n1 = len(s1)
    n2 = len(s2)
    map_ = {}

    for c in s1:
        map_[c] = True

    for c in s2:
        if c not in map_:
            return False

    return True

if __name__ == "__main__":
    main()