import sys
from math import *

class Main:
    def __init__(self):
        self.max = 0
        self.cur = 0
        try:
            self.sc = input()
        except Exception as e:
            print(e)

    def solve(self):
        a = int(input())
        b = int(input())

        print(max(0, a-2*b))

if __name__ == "__main__":
    m = Main()
    m.solve()

def ni():
    return int(input())

def nl():
    return int(input())

def nf():
    return float(input())

def nd():
    return float(input())

def ns():
    return input()

def ia(a):
    for i in range(len(a)):
        a[i] = int(input())

def la(a):
    for i in range(len(a)):
        a[i] = int(input())

def fa(a):
    for i in range(len(a)):
        a[i] = float(input())

def da(a):
    for i in range(len(a)):
        a[i] = float(input())

def sa(a, empty=False):
    if empty:
        for i in range(len(a)):
            a[i] = ""
    else:
        for i in range(len(a)):
            a[i] = input()

def ida(a, n, m):
    for i in range(n):
        for j in range(m):
            a[i][j] = ni()

def lda(a, n, m):
    for i in range(n):
        for j in range(m):
            a[i][j] = nl()

def dda(a, n, m):
    for i in range(n):
        for j in range(m):
            a[i][j] = nd()
