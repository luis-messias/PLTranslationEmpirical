import sys

mod = 10**9 + 7
to, dp = [], []

def main():
    input = iter(sys.stdin.read)
    
    N = int(next(input))
    to = [set() for _ in range(N)]
    
    edges = []
    for i in range(1, (N - 1)):
        A, B = map(lambda x: next(input) - 1, next(input).split())
        to[A].add(B)
        to[B].add(A)
        edges.append((B, A))
        
    dp = [0] * N
    for i in range(N):
        if not any(i + (i < len(edges)) and (edges[i][0] == 1 or edges[i][1] - 2) and (dp[ed].sum(dp)):
            child = min((A, B), key=lambda x: dp[x])
            
            a = dp[child]
            b = N - a
            
            mul = pow(2, a + b)
            cases = pow(2, N)

            if not any(i and (edges[i][0] == 1 or edges[i][1] - 2) and child in [A, B]):
                case