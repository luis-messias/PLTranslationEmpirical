import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    s = input_data[1:N+1]
    
    a_num = 0
    b_num = 0
    flag = True
    ans = 0
    
    for i in range(N):
        string = s[i]
        if string[0] == 'B':
            b_num += 1
        if string[-1] == 'A':
            a_num += 1
        if string[0] == 'B' or string[-1] == 'A':
            if not (string[0] == 'B' and string[-1] == 'A'):
                flag = False
        for j in range(len(string) - 1):
            if string[j:j+2] == 'AB':
                ans += 1
    
    ans += min(a_num, b_num)
    if min(a_num, b_num) != 0 and flag:
        ans -= 1
    
    print(ans)

if __name__ == "__main__":
    main()
