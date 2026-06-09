import collections
import sys

def main():
    map = collections.OrderedDict()
    n = int(input())
    for i in range(n):
        key, _ = input().split(maxsplit=1)
        map[key] = ""
    print(len(map))

if __name__ == "__main__":
    main()