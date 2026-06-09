import math

def main():
    n = int(input())
    sqrt = int(math.sqrt(n))
    answer = 0
    for i in range(2, sqrt + 1):
        count = 0
        while n % i == 0:
            n //= i
            count += 1
        for j in range(1, count + 1):
            if count - j >= 0:
                answer += 1
    if n > 1:
        answer += 1
    print(answer)

if __name__ == "__main__":
    main()