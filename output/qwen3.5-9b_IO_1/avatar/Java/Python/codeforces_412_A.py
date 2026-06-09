import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    k = int(input_data[1])
    a = input_data[2]
    
    if k > n / 2:
        while k < n:
            print("RIGHT")
            k += 1
    else:
        while k > 1:
            print("LEFT")
            k -= 1
    
    if k == 1:
        for i in range(len(a)):
            print("PRINT " + a[i])
            if (i + 1) < len(a):
                print("RIGHT")
    else:
        for i in range(len(a) - 1, -1, -1):
            print("PRINT " + a[i])
            if (i - 1) >= 0:
                print("LEFT")

if __name__ == "__main__":
    main()
