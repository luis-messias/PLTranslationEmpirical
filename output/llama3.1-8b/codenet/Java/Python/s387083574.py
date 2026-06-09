from collections import defaultdict
import operator

def main():
    N = int(input())
    map_ = defaultdict(int)
    for i in range(1, N + 1):
        map_[i] = int(input())

    sorted_map = dict(sorted(map_.items(), key=operator.itemgetter(1)))
    print(' '.join(str(key) for key in sorted_map.keys()))

if __name__ == "__main__":
    main()