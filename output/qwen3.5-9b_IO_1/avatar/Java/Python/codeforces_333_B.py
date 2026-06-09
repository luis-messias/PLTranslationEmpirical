import sys

def main():
    input_data = sys.stdin.read().split()
    idx = 0
    
    n = int(input_data[idx])
    idx += 1
    m = int(input_data[idx])
    idx += 1
    
    banned_rows = set()
    banned_cols = set()
    
    for _ in range(m):
        r = int(input_data[idx])
        idx += 1
        if r > 1 and r < n:
            banned_rows.add(r)
        c = int(input_data[idx])
        idx += 1
        if c > 1 and c < n:
            banned_cols.add(c)
    
    answer = (n - 2) * 2
    answer -= len(banned_rows)
    answer -= len(banned_cols)
    
    if n % 2 != 0:
        mid = (n + 1) // 2
        if mid not in banned_rows and mid not in banned_cols:
            answer -= 1
    
    print(answer)

if __name__ == "__main__":
    main()
