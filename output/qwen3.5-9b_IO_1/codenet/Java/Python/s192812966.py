import sys

def main():
    input_data = sys.stdin.read().split()
    w = int(input_data[0])
    h = int(input_data[1])
    n = int(input_data[2])
    
    xmax = w
    xmin = 0
    ymax = h
    ymin = 0
    
    for i in range(n):
        x = int(input_data[3 + i * 3])
        y = int(input_data[3 + i * 3 + 1])
        a = int(input_data[3 + i * 3 + 2])
        
        if a == 1:
            xmin = max(xmin, x)
        elif a == 2:
            xmax = min(xmax, x)
        elif a == 3:
            ymin = max(ymin, y)
        elif a == 4:
            ymax = min(ymax, y)
    
    w = max(xmax - xmin, 0)
    h = max(ymax - ymin, 0)
    
    print(w * h)

if __name__ == "__main__":
    main()
