from typing import List

def main():
    n, m, q = map(int, input().split())
    a = [0] * q
    b = [0] * q
    c = [0] * q
    d = [0] * q

    for i in range(q):
        a[i], b[i], c[i], d[i] = map(int, input().split())

    ans = -100

    def dfs(list: List[int]):
        nonlocal ans
        if len(list) == n:
            score = 0L
            for i in range(q):
                if (list[b[i]] - list[a[i]]) == c[i]:
                    score += d[i]
            ans = max(ans, score)
            return

        if list:
            for num in range(list[-1], m + 1):
                list.append(num)
                dfs(list.copy())
                list.pop()
        else:
            for num in range(1, m + 1):
                list.append(num)
                dfs(list.copy())
                list.pop()

    dfs([])
    print(ans)

if __name__ == "__main__":
    main()
