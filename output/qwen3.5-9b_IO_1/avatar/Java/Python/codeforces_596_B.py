import sys

def main():
    data = sys.stdin.read().split()
    n = int(data[0])
    arr = [int(x) for x in data[1:n+1]]
    answer = abs(arr[0])
    for i in range(1, n):
        answer += abs(arr[i] - arr[i-1])
    print(answer)

if __name__ == "__main__":
    main()
