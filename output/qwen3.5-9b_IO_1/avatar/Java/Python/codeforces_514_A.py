import sys

def main():
    x = int(input())
    list_digits = []
    while x > 0:
        r = x % 10
        if 9 - r < r:
            if x // 10 == 0 and 9 - r == 0:
                list_digits.append(r)
            else:
                list_digits.append(9 - r)
        else:
            list_digits.append(r)
        x = x // 10
    
    new_number = 0
    pow = 0
    for i in range(len(list_digits)):
        new_number = new_number + list_digits[i] * (10 ** pow)
        pow += 1
    
    print(new_number)

if __name__ == "__main__":
    main()
