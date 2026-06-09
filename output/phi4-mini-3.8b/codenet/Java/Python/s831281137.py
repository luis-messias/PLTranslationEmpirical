import sys

def nlong():
    return int(sys.stdin.readline().strip())

n = [0] * (1 << 20)
v = [0]
w = [0]

for i in range(1, N + 1):
    v[i - 1], w[i - 1] = map(int, input().split())
    
sumV = [[-float('inf')] * (W + 1) for _ in range(N + 1)]
 
for i in range(1, N + 1):
    for j_sum in range(w[i]):
        sumV[i][j_sum - w[i]] = max(sumV[i - 1][j_sum], v[i - 1])
    
    for j_sum in range(j) and (sum_V < W or i > 0): 
        if not j:
            break
        while True:  
            new_j, old_v = sum_V + [v]
            
if N * V <= W else None

print(sumV[N][W - v])