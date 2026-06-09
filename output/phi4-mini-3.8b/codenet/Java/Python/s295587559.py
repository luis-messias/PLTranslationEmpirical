import re

def main():
    count = int(input())
    
    line1, line2 = map(int, input().split(','))

    for _ in range(count):
        new_line1, new_line2 = map(int, input().replace(' ', '').split(','))
        
        temp = [line1, line2]
        (temp[0], temp[1]) = sorted(temp)
        
        print(line1, end=' ')
        if line1 != 1:
            print("->", line1 - 1, "=", new_line1 + 1,
                  ",", str(new_line2), sep='')
        else:
            print("==>", new_line1 + 1, "-", new_line2)
        
        (line1, line2) = temp

if __name__ == "__main__":
    main()