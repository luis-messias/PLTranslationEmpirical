import sys

def main():
    n = int(input())
    FfriendPerDay = [0] * 367
    MfriendPerDay = [0] * 367
    answer = 0
    for _ in range(n):
        c = input().strip()[0]
        day, a, b = map(int, input().split())
        for j in range(a, b + 1):
            if c == 'M':
                MfriendPerDay[j] += 1
            else:
                FfriendPerDay[j] += 1
            if MfriendPerDay[j] < FfriendPerDay[j]:
                answer = max(answer, MfriendPerDay[j])
            else:
                answer = max(answer, FfriendPerDay[j])
    print(answer * 2)

if __name__ == "__main__":
    main()
