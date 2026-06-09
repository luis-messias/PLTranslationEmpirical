import string

def main():
    S = input()
    T = input()

    A = list(string.ascii_lowercase)

    res = True
    for s in A:
        try:
            s_idx = S.index(s)
            t = T[s_idx]
            idx = 0
            while idx < len(S):
                if S.index(s, idx) != -1 and S.index(s, idx) != T.index(t, idx):
                    res = False
                    break
                elif T.index(t, idx) != -1:
                    res = False
                    break
                else:
                    idx = S.index(s, idx) + 1
        except ValueError:
            continue

        if not res:
            break

    print("Yes" if res else "No")

if __name__ == "__main__":
    main()