def bubble_sort(a):
    n = len(a)
    count = 0
    for i in range(n-1):
        flag = False
        for j in range(n-i-1):
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j]
                count += 1
                flag = True
        if not flag:
            break
    return count

def main():
    n = int(input())
    a = [int(x) for x in input().split()]
    count = bubble_sort(a)
    print(*a, sep=' ')
    print(count)

if __name__ == "__main__":
    main()