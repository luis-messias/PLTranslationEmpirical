import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    x = int(input_data[0])
    t = int(input_data[1])
    a = int(input_data[2])
    b = int(input_data[3])
    da = int(input_data[4])
    db = int(input_data[5])
    
    ok = False
    
    for i in range(t):
        first = a - (da * i)
        for j in range(t):
            second = b - (db * j)
            if second + first == x or second == x or first == x or x == 0:
                ok = True
                break
        if ok:
            break
    
    if ok:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    solve()
