import sys

def main():
    a, b, c = map(int, input().split())
    answer = "No"
    if a + b >= c:
        answer = "Yes"
    print(answer)

if __name__ == "__main__":
    main()
