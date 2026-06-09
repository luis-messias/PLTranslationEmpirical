import math

def main():
    n = int(input())
    sqrt = int(math.sqrt(n))
    answer = 0
    for i in range(2, int(math.sqrt(n)) + 1):
        count = 0
        while n % i == 0:
            n //= i
            count += 1
        if count > 1:
            answer += count - 1
    if n > 1:
        answer += 1
    print(answer)

if __name__ == "__main__":
    main()
