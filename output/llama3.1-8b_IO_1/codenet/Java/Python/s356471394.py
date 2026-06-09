import sys

N, M, D = map(int, input().split())
room = [[0]*M for _ in range(N)]
num = 0

def set_we():
    global num
    can_put = True

    for i in range(N):
        for j in range(M - D + 1):
            can_put = True

            for k in range(D):
                if room[i][j + k] == '#':
                    can_put = False
                    break

            if can_put:
                num += 1

def set_ns():
    global num
    can_put = True

    for i in range(M):
        for j in range(N - D + 1):
            can_put = True

            for k in range(D):
                if room[j + k][i] == '#':
                    can_put = False
                    break

            if can_put:
                num += 1

def input_room():
    global room
    nums = input().split()
    N = int(nums[0])
    M = int(nums[1])
    D = int(nums[2])

    for i in range(N):
        row = list(input())
        room[i] = [c == '#' for c in row]

if M >= D:
    set_we()
if N >= D:
    set_ns()

print(num)
