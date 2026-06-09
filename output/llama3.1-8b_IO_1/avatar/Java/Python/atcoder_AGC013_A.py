import sys

N = int(input())
A = list(map(int, input().split()))

count = 0
for i in range(N):
    if i == N - 1:
        count += 1
    elif A[i] == A[i + 1]:
        pass
    elif A[i] < A[i + 1]:
        while A[i] <= A[i + 1]:
            i += 1
            if i >= N: # Changed to check for index out of range
                break
        count += 1
    else:
        while A[i] >= A[i + 1]:
            i += 1
            if i >= N: # Changed to check for index out of range
                break
        count += 1

print(count)
