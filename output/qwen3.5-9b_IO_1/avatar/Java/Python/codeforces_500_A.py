import sys

def dfs(currpos, arr, target):
    if currpos == target:
        return True
    if currpos > len(arr):
        return False
    teleport = dfs(currpos + arr[currpos - 1], arr, target)
    if teleport:
        return True
    return False

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    n = int(input_data[0])
    goal = int(input_data[1])
    arr = [int(x) for x in input_data[2:]]
    isFound = dfs(1, arr, goal)
    if isFound:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()
