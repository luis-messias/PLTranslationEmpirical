import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    N = int(input_data[0])
    A = [int(x) for x in input_data[1:N+1]]
    A.sort()
    
    min_val = A[0]
    max_val = A[-1]
    
    mins = A.count(min_val)
    maxs = A.count(max_val)
    
    if min_val == max_val:
        result = (max_val - min_val) + " " + str(mins * (mins - 1) // 2)
    else:
        result = (max_val - min_val) + " " + str(mins * maxs)
    
    print(result)

if __name__ == "__main__":
    main()
