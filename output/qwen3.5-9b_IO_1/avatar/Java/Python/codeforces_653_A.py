import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    a = []
    for i in range(1, n + 1):
        a.append(int(input_data[i]))
    
    a = sorted(list(set(a)))
    
    found = False
    for i in range(len(a) - 2):
        if a[i] + 1 == a[i + 1] and a[i + 1] + 1 == a[i + 2]:
            found = True
            break
    
    print("YES" if found else "NO")

if __name__ == "__main__":
    main()
