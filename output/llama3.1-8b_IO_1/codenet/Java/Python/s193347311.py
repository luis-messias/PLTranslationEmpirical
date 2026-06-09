import sys

def main():
    loop = int(input())
    taro_score = 0
    hana_score = 0

    for _ in range(loop):
        taro_name, hana_name = input().split(), input().split()
        if taro_name[0] < hana_name[0]:
            hana_score += 3
        elif taro_name[0] == hana_name[0]:
            taro_score += 1
            hana_score += 1
        else:
            taro_score += 3

    print(taro_score, hana_score)

if __name__ == "__main__":
    main()
