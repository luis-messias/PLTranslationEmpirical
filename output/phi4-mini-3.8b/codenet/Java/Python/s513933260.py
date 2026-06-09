import sys

if __name__ == "__main__":
    input = iter(sys.stdin.read().splitlines())
    
    for line in input:
        if not line: continue
        
        result = (int(line) * (int(line) + 1)) // 2 - int(line)
        
        print(result)