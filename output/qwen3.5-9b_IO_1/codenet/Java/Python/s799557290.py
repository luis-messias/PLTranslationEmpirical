import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    a = int(input_data[0])
    b = int(input_data[1])
    
    ju = [False] * 100001
    pe = [0] * 100001
    
    idx = 2
    for _ in range(b):
        n = int(input_data[idx])
        res = input_data[idx + 1]
        idx += 2
        
        if res == "WA" and not ju[n - 1]:
            pe[n - 1] += 1
        
        if res == "AC":
            ju[n - 1] = True
    
    ac = 0
    wa = 0
    for i in range(a):
        if ju[i]:
            ac += 1
            wa += pe[i]
    
    print(f"{ac} {wa}")

if __name__ == "__main__":
    main()
