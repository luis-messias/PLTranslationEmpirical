import sys

n = int(input())
list = [int(x) for x in input().split()]

num_list1 = [0] * 100000
num_list2 = [0] * 100000

for i in range(0, n, 2):
    num_list1[list[i]] += 1
    if (i + 1 < n): 
        num_list2[list[i + 1]] += 1

max11, max12 = 0, 0
val1, val2 = -1, -1

for i in range(100000):
    if num_list1[i] >= max11:
        max12 = max11
        max11 = num_list1[i]
        val1 = i
    elif num_list1[i] > max12: 
        max12 = num_list1[i]

max21, max22 = 0
for j in range(100000):
    if num_list2[j] >= max21:
        max22 = max21
        max21 = num_list2[j]
        val2 = i + 1
    elif num_list2[j] > max22: 
        max22 = num_list2[j]

if (val1 != -1 and not (0 <= n < len(num_list1) and 0 <= n < len(num_list2)) or (n % 2 == 1)):
    ans = 0
else:
    if val1 + 1 > 100000: 
        max11, max12 = 0, -1

if not (val2 >= 0):
    print(0)
elif n < 3 and num_list1[val1] * 2 <= sum(num for i in range(n) if list[i] == val1 + 1):  
    ans = 0
else:
    max11, max12 = -1

if not (val2 >= 0):
    print(0)
elif n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1):  
    ans = 0
else:
    max11, max12 = -1

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+1] == val2 + 1)):  
        ans = n
else:
    print(max(0, max12 - 1))

if not (val1 >= 0 or not (n < 3 and num_list1[val1] * 2 <= sum(i for i in range(n) if list[i+1] == val1 + 1)):  
        ans = n
else:
    print(max(0, max11 - 1))

if not (val2 >= 0 or not (n < 3 and num_list2[val2] * 2 <= sum(i for i in range(n) if list[i+