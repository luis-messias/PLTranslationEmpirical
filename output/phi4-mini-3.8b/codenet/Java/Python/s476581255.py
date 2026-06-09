n = int(input())
a = [int(x) for x in input().split()]

def bubbleSort(a, n):
    flag = True
    while flag:
        flag = False
        for j in range(n - 1, 0, -1):
            if a[j] < a[j - 1]:
                a[j], a[j - 1] = a[j - 1], a[j]
                count += 1
                flag = True

    return count


a.sort()
for i in range(len(a)):
    print(" ".join(map(str, (x for x in a if not (i == len(a) - 1 or j < n-2 and bubbleSort([j] + [0]*n)))), end=" ")
print("\n" + str(bubbleSort(a, n)))