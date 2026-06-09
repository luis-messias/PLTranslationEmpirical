import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    numbers = [int(x) for x in input_data[1:N+1]]
    
    count = 0
    
    while True:
        numbers = [x // 2 for x in numbers if x % 2 == 0]
        if len(numbers) == N:
            count += 1
        if len(numbers) != N:
            break
    
    print(count)

if __name__ == "__main__":
    main()
