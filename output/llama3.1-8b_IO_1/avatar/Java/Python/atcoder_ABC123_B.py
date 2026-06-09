import sys

def main():
    a = []
    r = []
    
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

    map_ = dict(sorted(map_.items()))
    
    for i, (k, v) in enumerate(map_.items()):
        if i != 0 and k > r[idx]:
            ans += v + (10 - k)
        else:
            ans += v
    
    print(ans)

if __name__ == "__main__":
    map_ = {}
    main()
