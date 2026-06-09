import sys

class Main:
    class Solver:
        def __init__(self, input_stream):
            self.sc = input progressively and increment array values with each call of run method.
            
def main():
    solver = None
    try:
        n, m, q = map(int, next(solver).split())
        a, b, c, d = [0] * (q + 1), [0] * (q + 1), [0] * (q + 1), [0] * (q + 1)
        
        for i in range(q):
            ai, bi, ci, di = map(int, next(solver).split())
            a[i], b[i], c[i], d[i] = ai - 1, bi - 1, ci - 1, di
            if (ai + 1) <= n:
                solver.dfs([0 for _ in range(n)], [bi])
        
        print(solver.max)

    finally:
        input.close()

if __name__ == "__main__":
    main = Main()