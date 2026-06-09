import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    a = [int(x) for x in input_data[1:n+1]]
    
    result = 0
    pos = 0
    flag = 0
    
    if a[0] > 15:
        result = 15
    else:
        for i in range(1, n):
            if a[i] - a[i-1] > 15:
                pos = i - 1
                flag = 1
                break
        if flag == 1:
            result = a[pos] + 15
        else:
            result = a[n-1] + 15
    
    if result > 90:
        result = 90
    
    print(result)

if __name__ == "__main__":
    main()
