import sys

def main():
    n = int(input())
    input_str = input()
    max_len = -1
    msg_length = [0] * (len(input_str) // 2)
    idx = 0
    count = 0
    for i in range(len(input_str)):
        c = input_str[i]
        if c in ['.', '?', '!']:
            msg_length[idx] = count + 1
            max_len = max(max_len, count + 1)
            idx += 1
            count = 0
        else:
            count += 1

    if max_len > n:
        print("Impossible")
    else:
        ans = 0
        i = 0
        while i < len(msg_length):
            l = msg_length[i]
            while i + 1 < len(msg_length) and l + msg_length[i + 1] + 1 <= n:
                l += msg_length[i + 1] + 1
                i += 1
            ans += 1
            i += 1

        print(ans)

if __name__ == "__main__":
    main()
