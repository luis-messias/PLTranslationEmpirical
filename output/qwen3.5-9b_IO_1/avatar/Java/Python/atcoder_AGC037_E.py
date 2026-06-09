import sys

def main():
    try:
        input_data = sys.stdin.read().split()
        if len(input_data) >= 3:
            N = int(input_data[0])
            K = int(input_data[1])
            S = input_data[2]
            
            first_time = True
            step = 1
            
            while K > 0:
                T = S[::-1]
                revU = (S + T)[::-1]
                s_dash = S
                
                for i in range(N, -1, -step):
                    tmp = revU[i:i+N]
                    if s_dash > tmp:
                        s_dash = tmp
                    else:
                        if not first_time:
                            break
                
                if first_time:
                    first_time = False
                    if 2**K > N:
                        c = s_dash[0]
                        for _ in range(N):
                            print(c, end='')
                        print()
                        return
                
                else:
                    step *= 2
                
                K -= 1
                S = s_dash
                S = S[::-1]
            
            print(S[::-1])
    except Exception:
        pass

if __name__ == "__main__":
    main()
