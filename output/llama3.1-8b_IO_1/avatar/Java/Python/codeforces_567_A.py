import sys

def main():
    a = int(input())
    ar = [0] * (a + 1)
    for i in range(1, a + 1):
        line = input().split()
        ar[i] = int(line[0])

    for i in range(1, a + 1):
        max_val = max(ar[i] - ar[1], ar[a] - ar[i])
        if i == 1:
            min_val = ar[i + 1] - ar[i]
        elif i == a:
            min_val = ar[i] - ar[i - 1]
        else:
            min_val = min(ar[i] - ar[i - 1], ar[i + 1] - ar[i])
        print(min_val, max_val)

if __name__ == "__main__":
    main()
