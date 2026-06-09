import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    N = int(input_data[0])
    count1 = 0
    count2 = 0
    
    for i in range(N):
        a = int(input_data[i + 1])
        if a % 4 == 0:
            count1 += 1
        elif a % 2 == 0 and (a // 2) % 2 == 1:
            count2 += 1
    
    if count1 >= N // 2:
        print("Yes")
    elif ((N // 2 - count1) * 2 + N % 2) == count2:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()
