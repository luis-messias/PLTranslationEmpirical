import sys

def check_no(brr):
    val = 0
    for i in brr:
        if i == 1:
            val += 1
    return val

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    arr = [int(x) for x in input_data[1:n+1]]
    
    max_count = -float('inf')
    
    for i in range(n):
        for j in range(i, n):
            brr = arr.copy()
            for k in range(i, j + 1):
                if brr[k] == 0:
                    brr[k] = 1
                else:
                    brr[k] = 0
            count = check_no(brr)
            if count > max_count:
                max_count = count
    
    if n == 1:
        if arr[0] == 1:
            print(0)
        else:
            print(1)
    else:
        print(max_count)

if __name__ == "__main__":
    main()
