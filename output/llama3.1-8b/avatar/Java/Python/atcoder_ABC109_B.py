import sys
from collections import defaultdict

def main():
    N = int(input())
    map_ = defaultdict(str)
    for i in range(N):
        map_[i] = input()

    ans = True
    past = {}
    next_char = ""
    for i in range(N):
        if any(map_[i] == v for v in past.values()):
            ans = False
            break
        past[i] = map_[i]
        if i != 0:
            if not (next_char == map_[i][0]):
                ans = False
                break
        next_char = map_[i][-1]

    print("Yes" if ans else "No")

if __name__ == "__main__":
    main()