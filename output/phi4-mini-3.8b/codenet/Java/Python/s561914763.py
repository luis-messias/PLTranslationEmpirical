import input

ODD = {'R', 'U', 'D'}
EVE = {'L', 'U', 'D'}

N = input().strip()
is_good = True

for i, tap in enumerate(N):
    if (i + 1) % 2 == 0:
        if not is_match(EVE, tap):
            is_good = False
            break
    else:
        if not is_match(ODD, tap):
            is_good = False
            break

print("Yes" if is_good else "No")

def is_match(s, c):
    return str(c) in s