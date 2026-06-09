import sys

def main():
    input = iter(sys.stdin.read().splitlines()).__next__
    N = int(next(input))
    count1, count2 = 0, 0
    
    for i in range(N):
        a = next(input)
        if (a % 4) == 0:
            count1 += 1
        elif (a % 2) and ((a // 2) % 2) is not 0:
            count2 += 1
            
    if count1 >= N / 2 or (((N - count1 + int(N % 2)) * 2 == count2):
        print("Yes")
    else: 
        print("No")

if __name__ == "__main__":
    main()