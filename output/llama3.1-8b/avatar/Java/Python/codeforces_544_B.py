import sys

def print_island(n, count):
    a = (n + 1) // 2
    b = n // 2
    max_val = a * a + b * b
    
    if count > max_val:
        return "NO"
    
    result = []
    for i in range(n):
        row = ""
        for j in range(n):
            if (i + j) % 2 == 0 and count > 0:
                row += 'L'
                count -= 1
            else:
                row += 'S'
        result.append(row)
    
    return "YES\n" + "\n".join(result)

def main():
    n = int(input())
    count = int(input())
    print(print_island(n, count))

if __name__ == "__main__":
    main()