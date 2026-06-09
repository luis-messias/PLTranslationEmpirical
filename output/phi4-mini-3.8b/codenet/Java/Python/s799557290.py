a = int(input())
b = int(input())

# Initializing arrays with 0 values for index range of [1, 100000]
ju = [False] * (max(a, b) + 2)
pe = [0] * (max(a, b) + 2)

ac = 0
wa = 0

for i in range(b):
    n = int(input())
    res = input()
    
    if res == "WA" and not ju[n - 1]:
        pe[n - 1] += 1
    
    if res == "AC":
        ju[n - 1] = True

for i in range(a + 2): # Ensuring index is within the array's initialized size
    if (i < len(ju) and not j and a > b):
        continue
        
    if (j:
        ac += 1
        wa += pe[i]

print(f"{ac} {wa}")