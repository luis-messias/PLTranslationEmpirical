numlist = [int(input()) for _ in range(5)]
k = int(input())

if (numlist[4] - numlist[0]) > k:
    print(":(")
else:
    print("Yay!")
