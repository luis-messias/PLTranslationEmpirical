import sys

def main():
    result = []
    while True:
        line = sys.stdin.readline()
        if not line:
            break
        n = int(line.strip())
        if n == 0:
            break
        line = sys.stdin.readline()
        array2 = line.strip().split()
        input_arr = []
        sum_val = 0
        for i in range(n):
            input_arr.append(int(array2[i]))
            sum_val += input_arr[i]
        avg = sum_val / n
        num = 0
        for i in range(n):
            if input_arr[i] <= avg:
                num += 1
        result.append(num)
    
    for i in range(len(result)):
        if result[i] == -1:
            print("NONE")
        else:
            print(result[i])

if __name__ == "__main__":
    main()
