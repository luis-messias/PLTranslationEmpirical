import sys

def read():
    try:
        d = int(input())
        return True, d
    except ValueError:
        return False, None

def solve(d):
    ans = 0
    for i in range(1, 600 // d + 1):
        x = i * d
        y = x ** 2
        ans += y * d
    return ans

if __name__ == "__main__":
    while True:
        success, d = read()
        if not success:
            break
        print(solve(d))