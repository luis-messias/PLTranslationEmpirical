import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    A = [int(input_data[i + 1]) for i in range(N)]
    
    count = 0
    min_val = float('inf')
    sum_val = 0
    
    for x in A:
        if x < 0:
            count += 1
        min_val = min(min_val, abs(x))
        sum_val += abs(x)
    
    if count % 2 == 0:
        print(sum_val)
    else:
        print(sum_val - min_val * 2)

if __name__ == "__main__":
    main()
