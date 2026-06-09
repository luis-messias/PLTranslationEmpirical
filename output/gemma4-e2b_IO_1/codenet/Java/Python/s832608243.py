import sys

try:
    # Read a and b from standard input
    data = sys.stdin.read().split()
    if len(data) < 2:
        sys.exit()
    a = int(data[0])
    b = int(data[1])
except:
    sys.exit()

found = False
# Iterate i from 1 to 100000
for i in range(1, 100001):
    # Check if floor(i * 0.08) == a AND floor(i * 0.1) == b
    
    # Using int() for floor operation on positive results
    if int(i * 0.08) == a and b == int(i * 0.1):
        print(i)
        found = True
        break

if not found:
    print(-1)
