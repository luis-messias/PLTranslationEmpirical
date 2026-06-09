import sys

def main():
    n = int(input())
    a = list(map(int, input().split()))
    
    swap_count = 0
    
    for i in range(n):
        mini = i
        
        for j in range(i, n):
            if a[j] < a[mini]:
                mini = j
        if mini != i:
            a[i], a[mini] = a[mini], a[i]
            swap_count += 1
            
    print(*a)
    print(swap_count)

if __name__ == "__main__":
    main()