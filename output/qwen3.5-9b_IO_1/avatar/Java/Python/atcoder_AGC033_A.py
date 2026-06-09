import sys
from collections import deque

def main():
    input_data = sys.stdin.readline().split()
    H = int(input_data[0])
    W = int(input_data[1])
    A = []
    queue = deque()
    
    for i in range(H):
        row = sys.stdin.readline().strip()
        A.append(row)
        for j in range(W):
            if A[i][j] == '#':
                queue.append((i, j, 0))
    
    flag = [[0] * W for _ in range(H)]
    ans = 0
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while queue:
        y, x, depth = queue.popleft()
        
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            
            if 0 <= ny < H and 0 <= nx < W:
                if flag[ny][nx] == 0 and A[ny][nx] == '.':
                    flag[ny][nx] = 1
                    queue.append((ny, nx, depth + 1))
                    ans = depth + 1
    
    print(ans)

if __name__ == "__main__":
    main()
