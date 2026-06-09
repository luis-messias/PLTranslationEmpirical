import sys
from typing import List, Tuple

def main():
    N = int(input().split()[0])
    x = int(input())
    srime_list = [int(input()) for _ in range(N)]
    cost_list = [[0] * N for _ in range(N)]

    for i in range(N):
        cost_list[i][0] = srime_list[i]
        for cast_num in range(1, N):
            cost_list[i][cast_num] = min(cost_list[i][cast_num-1], srime_list[(i - cast_num + N) % N])

    result = [i * x + sum(cost_array[j] for cost_array in cost_list) for i, j in enumerate(range(N))]
    print(min(result))

if __name__ == "__main__":
    main()
