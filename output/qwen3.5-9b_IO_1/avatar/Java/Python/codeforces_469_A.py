import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    n = int(next(iterator))
    levels = int(next(iterator))
    
    arr = []
    for _ in range(levels):
        arr.append(int(next(iterator)))
    
    level2 = int(next(iterator))
    level3 = levels + level2
    
    arr2 = arr.copy()
    for _ in range(level3 - levels):
        arr2.append(int(next(iterator)))
    
    arr3 = list(range(1, n + 1))
    
    count = 0
    for i in arr3:
        if i in arr2:
            count += 1
    
    if count == n:
        print("I become the guy.")
    else:
        print("Oh, my keyboard!")

if __name__ == "__main__":
    main()
