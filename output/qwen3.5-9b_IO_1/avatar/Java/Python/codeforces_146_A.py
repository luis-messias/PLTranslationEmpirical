import sys

def main():
    n = int(input())
    s = input()
    
    # Check if all characters are '4' or '7'
    for char in s:
        if char != '4' and char != '7':
            print("NO")
            return
    
    # Calculate sums
    x = 0
    y = 0
    for i in range(n // 2):
        x += int(s[i])
    for i in range(n - 1, n // 2 - 1, -1):
        y += int(s[i])
    
    if x == y:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()
