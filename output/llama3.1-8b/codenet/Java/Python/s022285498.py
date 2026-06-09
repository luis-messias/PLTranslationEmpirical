import sys
from typing import List

class Task:
    def solve(self, n: int) -> None:
        count_arr = [0] * (n + 1)
        for x in range(1, 101):
            for y in range(1, 101):
                for z in range(1, 101):
                    value = x**2 + y**2 + z**2 + x*y + x*z + y*z
                    if value > n:
                        break
                    count_arr[value] += 1

        for i in range(1, n+1):
            print(count_arr[i])

def sort(arr: List[float]) -> None:
    arr.sort(reverse=True)

def solve() -> None:
    n = int(input())
    task = Task()
    task.solve(n)

if __name__ == "__main__":
    solve()