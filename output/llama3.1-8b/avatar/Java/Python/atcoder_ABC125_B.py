import sys

def str2list(str):
    v_list = {}
    for i, val in enumerate(str.split()):
        v_list[i] = int(val)
    return v_list

n = int(input())
v_str = input()
c_str = input()

v_list = str2list(v_str)
c_list = str2list(c_str)

max_profit = 0
for i in range(n):
    profit = v_list.get(i, 0) - c_list.get(i, 0)
    if profit > 0:
        max_profit += profit

print(max_profit)