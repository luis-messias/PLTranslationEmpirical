import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    constraints = [int(x) for x in input_data[1:6]]
    
    min_val = min(constraints)
    time = N // min_val
    if N % min_val != 0:
        time += 1
    time += 4
    
    print(time)

if __name__ == "__main__":
    main()
