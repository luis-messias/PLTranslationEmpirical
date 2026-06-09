import sys
from collections import defaultdict

class Card:
    def __init__(self):
        self.left = 0

    def __lt__(self, other):
        return self.left < other.left

cards = [Card() for _ in range(26)]

n, k = map(int, input().split())
s = input()

for i in range(n):
    cards[ord(s[i]) - ord('A')].left += 1

ans = 0
for i in range(k):
    cards.sort()
    change = min(cards[-1].left, k - i)
    ans += change * change
    cards[-1].left -= change
    i += change - 1

print(ans)