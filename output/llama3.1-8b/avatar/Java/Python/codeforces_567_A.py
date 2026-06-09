import sys

def main():
    a = int(input())
    ar = [0] * a
    for i in range(a):
        ar[i] = int(input())

    for i in range(a):
        max_val = max(ar[i] - ar[0], ar[-1] - ar[i])
        if i == 0:
            min_val = ar[i + 1] - ar[i]
        elif i == a - 1:
            min_val = ar[i] - ar[i - 1]
        else:
            min_val = min(ar[i] - ar[i - 1], ar[i + 1] - ar[i])
        print(min_val, max_val)

if __name__ == "__main__":
    main()