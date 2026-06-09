import sys
from collections import defaultdict, deque

NUM = 10**5 + 2
def main():
    N = int(input())
    map_ = {}
    nums = deque()
    for i in range(N):
        tmp = int(input())
        nums.append(tmp)
        map_[tmp] = i

    bin_, diff = 0, 0
    while nums:
        num = nums.popleft()
        idx = map_[num]
        if (bin_ % 2) != (idx % 2):
            diff += 1
        bin_ += 1
        bin_ %= 2

    ans = diff // 2
    print(ans)

if __name__ == "__main__":
    main()