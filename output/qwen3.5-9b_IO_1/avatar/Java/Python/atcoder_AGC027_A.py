import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    N = int(next(iterator))
    x = int(next(iterator))
    
    sweet = []
    for _ in range(N):
        sweet.append(int(next(iterator)))
    
    sweet.sort()
    
    num = 0
    for i in range(N):
        if x - sweet[num] >= 0:
            x = x - sweet[num]
            num += 1
        else:
            break
    
    if (num == N) and (x > 0):
        num -= 1
    
    print(num)

if __name__ == "__main__":
    main()
