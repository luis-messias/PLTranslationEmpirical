def calculate_area(w, h):
    return w * h

arr = [int(x) for x in input().split()]

area1 = calculate_area(arr[0], arr[1])
area2 = calculate_area(arr[2], arr[3])

if area1 > area2:
    print(area1)
elif area1 < area2:
    print(area2)
else:  # This else is not needed since we already checked for both conditions above
    pass