import sys

class atcoder_ABC128_C:
    def run(self):
        N, M = map(int, input().split())
        a = [0] * N
        for i in range(M):
            k = int(input())
            for j in range(k):
                s = int(input()) - 1
                a[s] |= (1 << i)
        p = 0
        for i in range(M):
            x = int(input())
            p |= (x << i)
        ans = 0
        for s in range(1 << N):
            t = 0
            for i in range(N):
                if (s >> i) & 1:
                    t ^= a[i]
            if p == t:
                ans += 1
        print(ans)

if __name__ == "__main__":
    main = atcoder_ABC128_C()
    main.run()