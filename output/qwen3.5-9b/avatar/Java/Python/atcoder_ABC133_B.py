import math
import sys

def main():
    input = sys.stdin.read
    data = input().split()
    iterator = iter(data)
    
    N = int(next(iterator))
    D = int(next(iterator))
    
    vectors = []
    for i in range(N):
        row = []
        for j in range(D):
            row.append(int(next(iterator)))
        vectors.append(row)
    
    answer = 0
    for i in range(N - 1):
        for j in range(i + 1, N):
            dist = 0
            for d in range(D):
                x = vectors[i][d] - vectors[j][d]
                dist += x * x
            sq = math.sqrt(dist)
            if abs(sq - math.floor(sq)) < 0.001:
                answer += 1
    
    print(answer)

if __name__ == "__main__":
    main()