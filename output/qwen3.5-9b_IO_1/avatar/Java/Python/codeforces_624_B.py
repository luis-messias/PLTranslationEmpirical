import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    ans = [int(x) for x in input_data[1:n+1]]
    ans.sort()
    count = ans[n - 1]
    for i in range(n - 2, -1, -1):
        if ans[i] < ans[i + 1]:
            count += ans[i]
        else:
            while ans[i] >= ans[i + 1]:
                ans[i] -= 1
            if ans[i] > 0:
                count += ans[i]
    print(count)

if __name__ == "__main__":
    main()
