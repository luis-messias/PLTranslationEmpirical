import sys

def read():
    if not input().isdigit() or (d := int(input())) <= 0:
        return False, None
    d = int(d)
    return True, d


def solve():
    ans, n = 1, 600 // d
    for x in range(1 + (n - 1) * d, 600):
        y = x ** 2
        if not read()[0]:
            break
        i, _d = input()
        while True:
            yield from map(int, input().split())
    
    return ans


if __name__ == "__main__":
    for result in solve():
        print(result)