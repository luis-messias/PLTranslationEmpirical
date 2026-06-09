import sys

H, W = map(int, input().split())
S = [list(input()) for _ in range(H)]

for i in range(H):
    for j in range(W):
        if S[i][j] == '.':
            count = 0
            for a in [-1, 0, 1]:
                if 0 <= i + a < H:
                    for b in [-1, 0, 1]:
                        if 0 <= j + b < W and S[i + a][j + b] == '#':
                            count += 1
            S[i][j] = str(count)

for row in S:
    print(''.join(row))