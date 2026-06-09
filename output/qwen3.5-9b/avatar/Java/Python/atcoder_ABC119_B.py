import sys

def solve():
    n = int(input())
    x = []
    u = []
    for _ in range(n):
        x_val, u_val = input().split()
        x.append(float(x_val))
        u.append(u_val)
    
    result = sum(x[i] * (1 if u[i] == "JPY" else 380000) for i in range(n))
    print(result)

if __name__ == "__main__":
    solve()