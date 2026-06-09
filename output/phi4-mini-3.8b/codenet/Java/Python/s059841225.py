import sys

def main():
    input = sys.stdin.read().strip()
    str_list = list(map(int, input.split(',')))
    
    if len(str_list) < 11:
        print("Input does not contain enough elements.")
        return
    
    l = [0] * 10 + str_list[10:12]
    d = sum(l[:10])
    v = (l[10], l[11])

    t = float(d) / (v[0] + v[1]) if (v[0] + v[1]) != 0 else 0

    for i in range(10, len(str_list)):
        d += str_list[i]
        if v[0] * t <= d:
            print(i)
            break