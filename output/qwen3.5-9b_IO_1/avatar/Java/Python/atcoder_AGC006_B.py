import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    x = int(input_data[1])
    
    max_val = n * 2 - 1
    
    if x == 1 or x == max_val:
        print("No")
        return
    
    print("Yes")
    
    sep = '\n'
    
    start = x + n - 1
    end = x + n + max_val - 1
    
    numbers = [(e % max_val + 1) for e in range(start, end)]
    ans = '\n'.join(map(str, numbers))
    
    print(ans)

if __name__ == "__main__":
    main()
