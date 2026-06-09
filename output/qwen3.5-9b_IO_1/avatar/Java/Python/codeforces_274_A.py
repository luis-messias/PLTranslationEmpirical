import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    k = int(input_data[1])
    arr = [int(input_data[i + 2]) for i in range(n)]
    arr.sort()
    count = 0
    seen = set()
    for i in range(n):
        if arr[i] % k != 0:
            count += 1
            seen.add(arr[i])
        else:
            if arr[i] // k not in seen:
                count += 1
                seen.add(arr[i])
    print(count)

if __name__ == "__main__":
    main()
