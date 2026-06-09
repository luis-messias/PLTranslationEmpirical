import sys

def answer(y, m, d):
    result = 1

    if y % 3 == 0:
        result += (20 - d)
    elif m % 2 == 0:
        result += (19 - d)
    else:
        result += (20 - d)

    for i in range(1, 11):
        if y % 3 == 0:
            result += 20
        else:
            if i % 2 == 0:
                result += 19
            else:
                result += 20

    for j in range(1, 1000):
        if (j + 1) % 3 == 0:
            result += 200
        else:
            result += 195

    return result


if __name__ == "__main__":
    input = sys.stdin.read
    data = list(map(int, input().split())
    
    for i in range(0, len(data), 1):
        y, m, d = data[i * 3:i * 3 + 3]
        print(answer(y - 1, (m if not 'i % 2 == 0 else 10) and 19 or 20, d))