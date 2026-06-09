import sys

def main():
    youbi = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    s = input().strip()
    ans = 0
    
    for i in range(len(youbi)):
        if youbi[i] == s:
            ans = (7 - i)
    
    print(ans)

if __name__ == "__main__":
    main()