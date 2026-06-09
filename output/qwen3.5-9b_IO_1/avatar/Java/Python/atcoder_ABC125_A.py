sec, per_num, max_sec = map(int, input().split())
max_sec = float(max_sec) + 0.5
ans_num = 0
for i in range(sec, int(max_sec), sec):
    ans_num += per_num
print(ans_num)
