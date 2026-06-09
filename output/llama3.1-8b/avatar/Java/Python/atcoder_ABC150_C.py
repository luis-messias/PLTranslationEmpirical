from typing import List

def permutation(list_, target: str, ans: str) -> None:
    if len(target) <= 1:
        list_.append(ans + target)
    else:
        for i in range(len(target)):
            permutation(list_, target[:i] + target[i+1:], ans + target[i])

def main():
    n = int(input())
    line = [["" for _ in range(1)] for _ in range(2)]
    for i in range(2):
        for j in range(n):
            line[i][0] += input()
    number = "".join(str(i) for i in range(1, n+1))
    listA = []
    permutation(listA, number, "")
    sum_ = 0
    for j in range(len(line)):
        for i in range(len(listA)):
            if listA[i] == line[j][0]:
                if sum_ == 0:
                    sum_ += i
                else:
                    sum_ -= i
    print(abs(sum_))

main()