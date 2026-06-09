import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    cnt = [0] * 21
    for i in range(1, n + 1):
        val = int(input_data[i])
        cnt[val + 10] += 1
    
    res = 0
    for i in range(10):
        res += cnt[i] * cnt[20 - i]
    
    res += cnt[10] * (cnt[10] - 1) // 2
    
    print(res)

if __name__ == "__main__":
    main()
