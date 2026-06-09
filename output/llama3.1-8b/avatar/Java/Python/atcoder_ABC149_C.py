import math

def main():
    x = int(input())
    if x != 2 and x % 2 == 0:
        x += 1
    while True:
        i = 3
        sqrt_num = math.sqrt(x)
        for _ in range(3, int(sqrt_num) + 1, 2):
            if x % _ == 0:
                break
        else:
            break
        x += 2
    print(x)

if __name__ == "__main__":
    main()