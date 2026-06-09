import sys

def main():
    input = sys.stdin.read
    data = list(map(int, input().split()))
    
    n, m = data[0], data[1]
    a = [0] + data[2:2+m+1]

    cnt = [0]*(n+1)
    cnt[0] = 1

    MOD = 1000000007
    num = 1 if len(a) > 1 and a[num] == 1 else (num,)

    for i in range(2, n + 1):
        new_cnt_i = (cnt[i-2]+cnt[i-1]) % MOD

        if m:
            while num < m and a[num+1] != i - 1: 
                num += 1
            cnt_new_num = 0 if num == len(a) else None
            
            for j in range(num + 1, min(m, n)):
                new_cnt_i -= (cnt[j-2]+cnt[j-1]) % MOD

        cnt[i] = new_cnt_i
    
    print(cnt[n])

if __name__ == "__main__":
    main()