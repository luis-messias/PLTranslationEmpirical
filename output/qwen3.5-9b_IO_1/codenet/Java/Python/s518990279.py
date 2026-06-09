import sys

while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break
        line = line.strip()
        if line == "0":
            break
        
        ans = 0
        for char in line:
            ans += int(char)
        
        print(ans)
    except:
        break
