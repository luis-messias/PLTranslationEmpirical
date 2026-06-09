import sys
from typing import List

def main():
    n = int(input())
    list_ = []
    for _ in range(n):
        list_.append(int(input()))
    list_.sort()
    c = 1
    for i in range(n):
        if list_[i] >= c:
            c += 1
    print(c)

if __name__ == "__main__":
    main()

def debug(obj):
    print(str(obj))