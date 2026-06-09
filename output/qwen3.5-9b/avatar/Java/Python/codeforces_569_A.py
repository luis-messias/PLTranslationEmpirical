import sys

def main():
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    S = int(data[1])
    q = int(data[2])
    previous = S
    answer = 0
    while previous < T:
        answer += 1
        previous *= q
    print(answer)

if __name__ == "__main__":
    main()