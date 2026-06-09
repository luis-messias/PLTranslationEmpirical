n = int(input())
ryuka = [0, 1]
for i in range(2, n + 1):
    ryuka.append(ryuka[i - 1] + ryuka[i - 2])
print(ryuka[n])