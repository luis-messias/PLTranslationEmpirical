import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is n
    n = int(input_data[0])
    
    # The next n elements form the array arr
    arr = [int(x) for x in input_data[1:n+1]]
    
    cnt = 0
    
    while True:
        flag = True
        
        # Check if all elements are even and divide them by 2
        for i in range(n):
            if arr[i] % 2 != 0:
                flag = False
                break
            else:
                # Use integer division
                arr[i] = arr[i] // 2
        
        if flag:
            cnt += 1
        else:
            break
            
    print(cnt)

solve()