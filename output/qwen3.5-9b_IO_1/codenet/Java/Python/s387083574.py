import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    values = list(map(int, input_data[1:N+1]))
    
    # Create dictionary with keys 1 to N
    d = {i+1: values[i] for i in range(N)}
    
    # Sort by value and get keys
    sorted_keys = sorted(d.keys(), key=lambda x: d[x])
    
    # Print keys separated by space
    print(' '.join(map(str, sorted_keys)))

if __name__ == "__main__":
    main()
