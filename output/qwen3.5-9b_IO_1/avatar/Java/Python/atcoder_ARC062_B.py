import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    test_cases = int(input_data[0])
    idx = 1
    
    for _ in range(test_cases):
        S = input_data[idx]
        idx += 1
        
        score = 0
        for i, char in enumerate(S):
            my = 'g' if i % 2 == 0 else 'p'
            his = char
            if my != his:
                if my == 'p':
                    score += 1
                else:
                    score -= 1
        
        print(score)

if __name__ == "__main__":
    solve()
