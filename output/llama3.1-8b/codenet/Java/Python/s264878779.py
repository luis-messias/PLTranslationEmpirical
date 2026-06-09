import sys
input = sys.stdin.readline

def main():
    s = input().strip()
    n = len(s)
    ans = 0
    for mask in range(1 << (n - 1)):
        sum_val = 0
        x = [s[0]]
        for i in range(n - 1):
            if (mask & (1 << i)) >= 1:
                x.append('+' + s[i + 1])
            else:
                x.append(s[i + 1])
        x = ''.join(x)
        split_x = x.split('+')
        for num in split_x:
            sum_val += int(num)
        ans += sum_val
    print(ans)

main()