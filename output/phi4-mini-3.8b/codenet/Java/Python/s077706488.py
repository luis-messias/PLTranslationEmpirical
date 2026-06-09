import sys

def main():
    N, X = map(int, input().split())
    m = [int(input()) for _ in range(N)]
    
    min_value = float('inf')
    total_sum = sum(m)
    
    if total_sum <= 0:
        print(-1)

    else: 
        result = (N + X) // max(1, abs(X // total_sum))
        
        # Adjusting the calculation for negative values
        adjustment_factor = -X / min_value if m[0] < 0 and N > 1 else None
        
        final_result = int(result * adjustment_factor)
        
        print(final_result)

if __name__ == "__main__":
    main()