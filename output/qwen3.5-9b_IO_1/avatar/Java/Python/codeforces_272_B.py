import sys

def rec(x):
    answer = 0
    for k in range(31, -1, -1):
        if (x & (1 << k)) != 0:
            answer += 1
    return answer

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    a = [0] * 33
    
    for i in range(n):
        val = int(input_data[i + 1])
        a[rec(val)] += 1
    
    answer = 0
    for i in range(len(a)):
        summ = (1 + a[i] - 1) / 2.0 * (a[i] - 1)
        answer += summ
    
    print(int(answer))

if __name__ == "__main__":
    main()
