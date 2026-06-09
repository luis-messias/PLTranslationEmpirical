import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    array = [int(x) for x in input_data[1:n+1]]
    
    max_val = max(array)
    min_val = min(array)
    
    print(max_val - min_val)

if __name__ == "__main__":
    main()
