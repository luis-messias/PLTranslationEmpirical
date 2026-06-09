import sys

def main():
    input_data = sys.stdin.read().split()
    r = int(input_data[0])
    d = int(input_data[1])
    x = int(input_data[2])
    
    for _ in range(10):
        x = r * x - d
        print(x)

if __name__ == "__main__":
    main()
