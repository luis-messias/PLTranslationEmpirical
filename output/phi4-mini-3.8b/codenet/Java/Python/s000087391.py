import sys

def main():
    result = []
    
    while True:
        line = input()
        n = int(line)
        
        if n == 0:
            break
        
        for _ in range(n):
            pass
            
        array2_line = input().strip()
        arr = list(map(int, array2_line.split()))
        
        sum_arr = sum(arr)
        avg = float(sum_arr) / len(arr)

        num_below_avg = sum(1 for x in arr if x <= avg)
        result.append(num_below_avg)

    print("\n".join(str(x) if x != -1 else "NONE" for x in result))

if __name__ == "__main__":
    main()