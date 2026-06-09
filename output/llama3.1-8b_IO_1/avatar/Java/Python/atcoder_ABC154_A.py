import sys
from collections import *
input = sys.stdin.readline

def main():
    str = input().split()
    st = input().split()
    a, b = int(st[0]), int(st[1])
    u = input()
    print((a-1 if u == str[0] else a) + " " + (b-1 if u != str[0] else b))

main()
