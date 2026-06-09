import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    m = int(input_data[1])
    
    lines = input_data[2:]
    
    ans = []
    for i in range(n):
        row = ""
        for j in range(m):
            if lines[i][j] == '-':
                row += "-"
            else:
                if (i + j) % 2 == 1:
                    row += "W"
                else:
                    row += "B"
        ans.append(row)
    
    for row in ans:
        print(row)

if __name__ == "__main__":
    main()
