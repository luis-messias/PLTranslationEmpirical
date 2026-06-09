from collections import defaultdict

try:
    n, m = map(int, input().split())

    map_ = defaultdict(int)
    count_ac = 0
    count_wa_all = 0

    for _ in range(m):
        question, wa_or_ac = input().split()
        question = int(question)

        if question not in map_:
            if wa_or_ac == "WA":
                map_[question] += 1
            else:
                map_[question] -= 1
                count_ac += 1
        else:
            count_wa = map_[question]

            if count_wa >= 0:
                if wa_or_ac == "WA":
                    map_[question] += 1
                else:
                    map_[question] -= 1
                    count_ac += 1
                    count_wa_all += count_wa

    print(count_ac, count_wa_all)

except Exception as e:
    print(e)