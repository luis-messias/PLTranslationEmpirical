import sys

def main():
    input = sys.stdin.readline
    
    n, m = map(int, input().split())
    
    penal = [0] * (n + 1)
    solved = [False] * (n + 1)

    for _ in range(m):
        num = int(input().strip())
        str_val = input().strip()
        
        if str_val[0] == 'A':
            solved[num] = True
        elif not solved[num]:
            penal[num] += 1

    correct_ans, num_penal = sum(solved), sum(pen for s, p in zip(solved, penal) if s)

    print(f"{correct_ans} {num_penal}")

if __name__ == "__main__":
    main()