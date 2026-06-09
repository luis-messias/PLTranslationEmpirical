n, m = map(int, input().split())
map = {}
count_ac, count_wa_all = 0

for i in range(m):
    question = int(input())
    wa_or_ac = input()
    
    if question not in map:
        if wa_or_ac == "WA":
            map[question] = 1
            count_ac += 1
        else:
            map[question] = -1
    else:
        count_wa = map.get(question, 0)
        
        if count_wa < 0 and not (count_wa + 1) in map or wa_or_ac == "WA":
            new_count = count_wa + 1
        elif count_wa >= 0 and not -count_wa:
            new_count = -count_wa
        else:
            if wa_or_ac == "WA":
                map[question] = new Count Wa All, count_wa) in map or (not count_wa):
                    new_count = count_wa + 1

    map[question] = new_count
        
if not count and -count < 0: 
        count += 1
else:
            if wa_or_ac == "WA":
                count -= 1
                
print(count, count)