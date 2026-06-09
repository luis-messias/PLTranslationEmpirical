import sys

def Answer(y, m, d):
    result = 1
    
    if y % 3 == 0:
        result += 20 - d
    elif m % 2 == 0:
        result += 19 - d
    else:
        result += 20 - d
    
    for m in range(m + 1, 11):
        if y % 3 == 0:
            result += 20
        elif m % 2 == 0:
            result += 19
        else:
            result += 20
    
    for y in range(y + 1, 1000):
        if y % 3 == 0:
            result += 200
        else:
            result += 195
    
    return result

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    count = int(next(iterator))
    
    for _ in range(count):
        y = int(next(iterator))
        m = int(next(iterator))
        d = int(next(iterator))
        print(Answer(y, m, d))

if __name__ == "__main__":
    main()
