import sys

def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)

def lcm(a, b):
    return (a * b) // gcd(a, b)

def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

class FastReader:
    def __init__(self):
        self.br = sys.stdin

    def next(self):
        return self.br.readline().strip()

    def nextInt(self):
        return int(self.next())

    def nextLong(self):
        return int(self.next())

    def nextDouble(self):
        return float(self.next())

    def nextLine(self):
        return self.br.readline().strip()

class FastWriter:
    def __init__(self):
        self.bw = sys.stdout

    def print(self, obj):
        self.bw.write(str(obj))

    def println(self, obj):
        self.print(obj)
        self.bw.write('\n')

    def close(self):
        self.bw.close()

class Solution:
    def solve(self):
        n = int(input())
        arr = list(map(int, input().split()))
        for i in range(n - 1):
            if arr[i] > arr[i + 1]:
                print("NO")
                return
        print("YES")

if __name__ == "__main__":
    t = 1
    while t > 0:
        t -= 1
        solution = Solution()
        solution.solve()

class Main:
    def main(self):
        fastReader = FastReader()
        fastWriter = FastWriter()
        solution = Solution()
        solution.solve()
        fastWriter.close()

if __name__ == "__main__":
    main_obj = Main()
    main_obj.main()
