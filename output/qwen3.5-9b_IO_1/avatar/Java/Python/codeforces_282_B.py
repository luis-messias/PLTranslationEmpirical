import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    s1 = 0
    s2 = 0
    ch = []
    flag = 0
    
    idx = 1
    for i in range(n):
        x = int(input_data[idx])
        y = int(input_data[idx + 1])
        idx += 2
        
        temp1 = s1 + x
        temp2 = s2 + y
        
        if abs(temp1 - s2) <= 500:
            s1 += x
            ch.append('A')
            continue
        
        if abs(temp2 - s1) <= 500:
            s2 += y
            ch.append('G')
            continue
        
        flag = 1
        break
    
    if flag == 1:
        print(-1)
    else:
        print(''.join(ch))

if __name__ == "__main__":
    main()
