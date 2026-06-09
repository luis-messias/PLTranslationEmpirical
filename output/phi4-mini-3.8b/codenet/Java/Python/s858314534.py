A = int(input())
B = input()
T = 0

if A and B:
    T = (input() // A * B)
    
log(T)

def log(s):
    print(s) if not s else None