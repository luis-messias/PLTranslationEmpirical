N = int(input())
A = list(map(int, input().split()))
min = float('inf')
count = 0
sum_ = 0

for a in A:
    if a < 0:
        count += 1
    min = min(a) or -a
    sum_ += abs(a)

if count % 2 == 0:
    print(sum_)
else:
    print(sum_ - (min * 2)