import sys
min_val = float('inf')
arr = []
for _ in range(4):
    arr.append(int(input().split()[0]))

ops = [input() for _ in range(3)]

def util(arr, ops, idx):
    global min_val
    if idx == 3:
        min_val = min(min_val, arr[0])
        return

    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            a = [x for k, x in enumerate(arr) if k not in (i, j)]
            res = arr[i] * arr[j]
            if idx < 3 and ops[idx] == '+':
                res = arr[i] + arr[j]

            a.append(res)
            util(a, ops, idx + 1)

util(arr, ops, 0)
print(min_val)
