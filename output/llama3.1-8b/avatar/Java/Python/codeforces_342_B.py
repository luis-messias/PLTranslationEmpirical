import sys

def main():
    input_str = sys.stdin.readline().strip()
    m, s, f = map(int, input_str.split())

    max_t = -1
    map_ = {}
    while m > 0:
        line = sys.stdin.readline().strip().split()
        k = int(line[0])
        if k not in map_:
            map_[k] = []
        map_[k].append(int(line[1]))
        map_[k].append(int(line[2]))
        max_t = max(max_t, k)
        m -= 1

    actions = ''
    M = 'R' if s < f else 'L'
    d = +1 if s < f else -1
    cur = s
    for t in range(1, max_t+1):
        if t in map_:
            a, b = map_[t]
        if t in map_ and (cur >= a and cur <= b or cur+d >= a and cur+d <= b):
            actions += 'X'
        else:
            actions += M
            cur += d
        if cur == f:
            break

    while cur != f:
        actions += M
        cur += d

    print(actions)

if __name__ == "__main__":
    main()