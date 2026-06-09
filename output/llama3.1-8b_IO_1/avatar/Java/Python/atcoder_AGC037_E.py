import sys

def main():
    N, K = map(int, input().split())
    S = list(input())

    first_time = True
    step = 1

    while K > 0:
        T = S[::-1]
        rev_U = S + T[::-1]

        s_dash = ''.join(S)
        for i in range(N, -step, -step):
            tmp = ''.join(rev_U[i:i+step])
            if s_dash > tmp:
                s_dash = tmp
            else:
                if not first_time:
                    break

        if first_time:
            first_time = False
            if 2**K > N:
                c = s_dash[0]
                print(c * N)
                sys.exit(0)

        step += step
        K -= 1
        S = list(s_dash[::-1])

    print(''.join(S[::-1]))

if __name__ == "__main__":
    main()
