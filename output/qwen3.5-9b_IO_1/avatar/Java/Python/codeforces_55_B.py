import sys

min_val = float('inf')

def util(arr, ops, idx):
    global min_val
    if idx == 3:
        min_val = min(min_val, arr[0])
        return
    
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            new_arr = []
            for k in range(len(arr)):
                if k != i and k != j:
                    new_arr.append(arr[k])
            
            if idx < 3 and ops[idx] == "+":
                res = arr[i] + arr[j]
            else:
                res = arr[i] * arr[j]
            
            new_arr.append(res)
            util(new_arr, ops, idx + 1)

def main():
    arr = list(map(int, input().split()))
    ops = input().split()
    util(arr, ops, 0)
    print(min_val)

if __name__ == "__main__":
    main()
