from collections import defaultdict
import sys

def main():
    str = input()
    map_ = defaultdict(int)
    odd_count = 0
    for ch in str:
        if ch in map_:
            map_[ch] += 1
        else:
            map_[ch] = 1
    for key, value in map_.items():
        if value % 2 != 0:
            odd_count += 1
    if odd_count <= 1 or odd_count % 2 != 0:
        print("First")
    else:
        print("Second")

if __name__ == "__main__":
    main()