import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    k = int(input_data[1])
    bb = [int(x) for x in input_data[2:2+n]]
    
    aa = [0] * n
    m = 0
    
    for a in range(n - 1, -1, -1):
        j = 0
        while bb[a] > 0:
            if aa[j] >= a + k:
                bb[a] -= 1
                j += 1
        for j_ in range(m, j, -1):
            aa[j_] = aa[j_ - 1]
        aa[j] = a
    
    for i in range(n):
        print(aa[i] + 1, end=' ')
    print()

if __name__ == "__main__":
    main()
