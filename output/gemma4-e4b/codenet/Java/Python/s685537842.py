import sys

def main():
    # Read all input data from stdin
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        a = int(data[0])
        b = int(data[1])
        t = int(data[2])
    except Exception:
        return

    time = 0.0
    count = 0
    
    while time < t + 0.5:
        count += b
        time += a
        
        if time > t + 0.5:
            count -= b
            break
            
    print(count)

if __name__ == "__main__":
    main()