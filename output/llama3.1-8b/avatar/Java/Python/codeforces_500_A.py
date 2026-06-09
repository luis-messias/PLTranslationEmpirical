from typing import List

def dfs(currpos: int, arr: List[int], target: int) -> bool:
    if currpos == target:
        return True
    if currpos == len(arr) + 1:
        return False
    teleport = dfs(currpos + arr[currpos - 1], arr, target)
    if teleport:
        return True
    return False

def main():
    n = int(input())
    goal = int(input())
    arr = [int(x) for x in input().split()][:-1]
    isFound = dfs(1, arr, goal)
    print("YES" if isFound else "NO")

if __name__ == "__main__":
    main()