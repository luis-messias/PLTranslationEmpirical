from typing import List

def dfs(currpos: int, arr: List[int], target: int) -> bool:
    if currpos == target:
        return True
    if currpos > len(arr):
        return False
    teleport = dfs(currpos + arr[currpos - 1], arr, target)
    if teleport:
        return True
    return dfs(currpos + 1, arr, target)

def main():
    n = int(input())
    goal = int(input())
    arr = list(map(int, input().split()))[:-1]
    isFound = dfs(1, arr, goal)
    print("YES" if isFound else "NO")

if __name__ == "__main__":
    main()
