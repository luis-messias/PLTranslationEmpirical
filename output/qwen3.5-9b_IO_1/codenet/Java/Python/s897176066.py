import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    N = int(input_data[0])
    A = [int(x) for x in input_data[1:N+1]]
    A.sort()
    
    for j in range(1, N):
        if A[j] == A[j-1]:
            print("NO")
            return
    
    print("YES")

if __name__ == "__main__":
    main()
