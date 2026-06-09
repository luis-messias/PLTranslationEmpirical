import sys

def main():
    line = input()
    N, M = map(int, line.split())
    shortage = []

    for _ in range(M):
        line = input()
        A = int(line.split()[0])
        shortage.append(max(0, N - A))

    shortage.sort()

    ans = sum(shortage[:-1])
    print(ans)

if __name__ == "__main__":
    main()
