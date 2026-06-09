import sys

def solve():
    n = int(input())
    count_arr = [0] * (n + 1)
    
    for x in range(1, 101):
        for y in range(1, 101):
            for z in range(1, 101):
                value = x * x + y * y + z * z + x * y + x * z + y * z
                if value > n:
                    break
                count_arr[value] += 1
    
    for i in range(1, n + 1):
        print(count_arr[i])

if __name__ == "__main__":
    solve()
