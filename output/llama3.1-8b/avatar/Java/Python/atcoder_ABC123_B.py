import sys

def main():
    a = []
    r = []
    map_ = {}
    
    for _ in range(5):
        a.append(int(input()))
        r.append(a[-1] % 10)
        
        if r[-1] != 0:
            b = 10 - r[-1]
            map_[b] = a[-1]

    ans = sum(a)

    if len(map_) == 0:
        print(ans)
        return

    last = list(map_.values())[-1]
    idx = None
    for i, x in enumerate(a):
        if x == last:
            idx = i

    for i, x in enumerate(a):
        if i != idx:
            if r[i] == 0:
                ans += x
            else:
                ans += x + (10 - r[i])

    ans += last
    print(ans)

if __name__ == "__main__":
    main()