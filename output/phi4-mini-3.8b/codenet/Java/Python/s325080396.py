MAX = 200000

def main():
    n = int(input())
    R = [int(input()) for _ in range(n)]
    
    maxv, minv = abs(R[1] - R[0]), R[0]
    
    for i in range(1, len(R)):
        current_diff = abs(R[i] - minv)
        if current_diff > maxv:
            maxv = current_diff
        new_minv = min(minv, R[i])
        
    print(maxv)

if __name__ == "__main__":
    main()