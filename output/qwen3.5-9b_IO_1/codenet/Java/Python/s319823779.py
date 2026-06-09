import sys

def main():
    input_data = sys.stdin.read().split()
    a = int(input_data[0])
    b = int(input_data[1])
    c = int(input_data[2])
    x = int(input_data[3])
    
    res = 0
    
    for i in range(a + 1):
        for j in range(b + 1):
            for k in range(c + 1):
                total = 500 * i + 100 * j + 50 * k
                
                if total == x:
                    res += 1
    
    print(res)

if __name__ == "__main__":
    main()
