import sys

N, M = map(int, input().split())
shortage = [max(0, N - parse_int(input())) for _ in range(M)]
print(sum(sorted(shortance)[:-1])