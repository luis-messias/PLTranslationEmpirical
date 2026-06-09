import sys
def main():
    n = int(input())
    left = [0]*n
    right = [0]*n
    for i in range(n):
        left[i], right[i] = map(int, input().split())
    sum = 0
    for i in range(n):
        sum += (right[i] - left[i] + 1)
    print(sum)

if __name__ == "__main__":
    main()