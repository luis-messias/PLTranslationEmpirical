import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    strings = input_data[1:N+1]
    
    past = set()
    ans = True
    
    for i in range(N):
        if strings[i] in past:
            ans = False
            break
        past.add(strings[i])
        
        if i != 0:
            if strings[i][0] != strings[i-1][-1]:
                ans = False
                break
    
    if ans:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()