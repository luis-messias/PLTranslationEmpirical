import sys

if __name__ == "__main__":
    r = int(sys.stdin.readline().strip())
    
    if r < 1200:
        print("ABC")
    elif r < 2800:
        print("ARC")
        
    else:
        print("AGC")