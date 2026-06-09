import sys

sc = input().split()
sec = int(sc[0])
per_num = int(sc[1])
max_sec = float(sc[2]) + 0.5
ans_num = 0
for i in range(sec, int(max_sec)):
    ans_num += per_num
print(ans_num)
