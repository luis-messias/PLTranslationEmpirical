import sys

def main():
    n = int(sys.stdin.readline().strip())
    map_dict = {}
    
    for _ in range(n):
        a = int(input().strip())
        if a in map_dict:
            map_dict[a] += 1
        else:
            map_dict[a] = 1
    
    ans = sum(1 for key, value in map_dict.items() if value % 2 == 1)
    
    print(ans)

if __name__ == "__main__":
    main()