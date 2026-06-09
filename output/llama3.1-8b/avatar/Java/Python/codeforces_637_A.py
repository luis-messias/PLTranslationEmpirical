import sys
from collections import defaultdict, Counter

def main():
    n = int(input())
    ara = [int(x) for x in input().split()]
    map_ = defaultdict(int)
    for v in ara:
        if v not in map_:
            map_[v] = 1
        else:
            map_[v] += 1

    max_val = max(map_.values())
    mm = defaultdict(int)
    for i, v in enumerate(ara):
        if v not in mm:
            mm[v] = 1
            if mm[v] == max_val:
                print(v)
                break
        else:
            mm[v] += 1
            if mm[v] == max_val:
                print(v)
                break

if __name__ == "__main__":
    main()