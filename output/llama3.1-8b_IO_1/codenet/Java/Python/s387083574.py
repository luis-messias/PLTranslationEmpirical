from collections import defaultdict

def main():
    N = int(input())
    map_ = defaultdict(int)
    for i in range(1, N + 1):
        line = input()
        numbers = [int(x) for x in line.split()]
        map_[i] = max(numbers)

    sorted_map = dict(sorted(map_.items(), key=lambda x: x[1]))
    print(' '.join(str(key) for key in sorted_map.keys()))

if __name__ == "__main__":
    main()
