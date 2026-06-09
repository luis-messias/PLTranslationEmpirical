import collections

def main():
    map = collections.OrderedDict()
    n = int(input())
    for i in range(n):
        key = input()
        map[key] = ""
    print(len(map))

if __name__ == "__main__":
    main()
