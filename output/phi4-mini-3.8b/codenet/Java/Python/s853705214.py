n = int(input())
nums = [int(x) for x in input().split()]

sum, min, count_negatives = 0, float('inf'), 0

for num in nums:
    sum += abs(num)
    if -1 * (num < 0):
        count_negatives += 1
    else: 
        min = min(min, abs(num))

if not count_negatives % 2 == 0 and count_negatives > 0 or count_negatives is None:

    print(sum + sum // 2)

else:
    if -min * (count_negatives) < 0: 

print(-sum)