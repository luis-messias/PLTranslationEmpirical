import sys
from random import randint

def gcd(x, y):
    while(y):
        x, y = y, x % y
    return abs(x)

class Solver:
    def __init__(self):
        self.MOD = 10**9 + 7
        self.MAXN = 1000006
        self.primes = []
        for i in range(2, self.MAXN): 
            if all(i % p != 0 for p in self.primes):
                self.primes.append(i)
    
    def solve(self, tc=1):
        while True:
            N = int(input())
            K = int(input())
            A = list(map(int, input().split()))
            
            straight = []
            cycle = []

            vis = [False] * len(A)

            curr = 0
            while not vis[curr]:
                vis[curr] = True
                curr = (A[curr]-1) % N

            st = 0
            while st != curr:
                straight.append(st)
                st = A[st]
            
            cycle_start_index = next(i for i, v in enumerate(vis) if v)

            curr = A[cycle_start_index] - 1
            while curr not in [straight[-1], cycle_start_index]:
                cycle.append(curr)
                curr = (A[curr]-1 + N) % N

            straight.reverse()
            
            K -= len(straight)
            result = str(cycle[K%len(cycle)]+1 if K < len(straight) else straight[K//len(cycle)])
            print(result)

def main():
    solver = Solver()

if __name__ == "__main__":
    try:
        tc = int(input())
        for _ in range(tc):
            solver.solve()
    except Exception as e:
        sys.exit(1)