import math
import sys

def main():
    N, D = map(int, input().split())
    vectors = [[int(x) for x in input().split()] for _ in range(N)]

    answer = 0
    for i in range(N - 1):
        for j in range(i + 1, N):
            dist = sum((x - y) ** 2 for x, y in zip(vectors[i], vectors[j]))
            sq = math.sqrt(dist)
            if abs(sq - round(sq)) < 0.001:
                answer += 1

    print(answer)

if __name__ == "__main__":
    main()