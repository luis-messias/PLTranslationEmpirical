import sys

def solve(x, u):
    total = 0.0
    for i in range(len(x)):
        # x[i] is double, u[i] is string
        multiplier = 1 if u[i] == "JPY" else 380000
        total += x[i] * multiplier
    return total

def main():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first token
    N = int(data[0])
    
    x = []
    u = []
    
    # data[1] onwards contains N pairs of (x, u)
    # x values start at index 1, u values start at index 2
    for i in range(N):
        # x[i] is at index 1 + 2*i
        x.append(float(data[1 + 2 * i]))
        # u[i] is at index 2 +