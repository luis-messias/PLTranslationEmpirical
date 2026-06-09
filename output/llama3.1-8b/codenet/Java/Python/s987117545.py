import math

DEVISOR = 1000000000+7
sc = input

def main():
    n = int(sc())
    k = int(sc())

    ans = 0
    for i in range(k, n + 2):
        max_val = (i * (2 * n - i + 1)) // 2
        min_val = (i * (i - 1)) // 2
        ans += ((max_val - min_val + 1) % DEVISOR)
    print((ans % DEVISOR))

if __name__ == "__main__":
    main()