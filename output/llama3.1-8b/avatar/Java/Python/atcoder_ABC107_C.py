import sys

N, K = map(int, input().split())
S = list(map(int, input().split()))

if K == 1:
    ans = min(abs(x) for x in S)
else:
    if N - K != 0:
        for i in range(N-K+1):
            min_val = min(S[i], S[i+K-1])
            max_val = max(S[i], S[i+K-1])
            temp = (min_val < 0 and max_val > 0) and min(2*(-min_val)+max_val, -min_val+2*max_val) or max(abs(min_val), abs(max_val))
            ans = min(ans, temp)
    else:
        min_val = S[0]
        max_val = S[-1]
        ans = (min_val < 0 and max_val > 0) and min(2*(-min_val)+max_val, -min_val+2*max_val) or max(abs(min_val), abs(max_val))

print(ans)