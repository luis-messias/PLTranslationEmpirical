import sys

def main():
    N = int(input())
    count1 = 0
    count2 = 0
    for _ in range(N):
        line = input()
        numbers = [int(x) for x in line.split()]
        for a in numbers:
            if a % 4 == 0:
                count1 += 1
            elif a % 2 == 0 and (a // 2) % 2 == 1:
                count2 += 1
    if count1 >= N / 2 or ((N / 2 - count1) * 2 + N % 2) == count2:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()
