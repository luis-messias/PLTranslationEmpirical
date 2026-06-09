import sys

def main():
    n = int(input())
    nums = list(map(int, input().split()))
    
    odd = []
    sum = 0
    for i in nums:
        if i % 2 == 0:
            sum += i
        else:
            odd.append(i)
    
    odd.sort()
    for i in odd:
        sum += i
    
    if len(odd) % 2 != 0:
        sum -= odd[0]
    
    print(sum)

if __name__ == "__main__":
    main()
