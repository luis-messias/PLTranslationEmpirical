import sys
from typing import List

def main():
    N = int(input())
    size = 1 << N
    S = [0] * size
    spawned = [False] * size
    spawned[size - 1] = True
    for i in range(size):
        S[i] = int(input().split()[i])
    S.sort(reverse=True)
    active = [S[-1]]
    spawned[size - 1] = True
    for _ in range(N):
        active.sort(reverse=True, key=lambda x: -x)
        activated = []
        next = size - 1
        for slime in active:
            while next >= 0 and (S[next] >= slime or spawned[next]):
                next -= 1
            if next < 0:
                print("No")
                return
            spawned[next] = True
            activated.append(S[next])
        active.extend(activated)
    print("Yes")

if __name__ == "__main__":
    main()
