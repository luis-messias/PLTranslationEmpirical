import sys

def main():
    n, a, b = map(int, sys.stdin.readline().split())
    list1 = list(map(int, sys.stdin.readline().split()))
    list2 = list(map(int, sys.stdin.readline().split()))
    
    for i in range(1, n + 1):
        if i in list1:
            print(1, end=' ')
        else:
            print(2, end=' ')
    print()

if __name__ == "__main__":
    main()
