import sys
from collections import deque, defaultdict

class PriorityQueue:
    def __init__(self):
        self.heap = []

    def push(self, value):
        self.heap.append(value)
        self._heapify_up(len(self.heap) - 1)

    def pop(self):
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        min_value = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)
        return min_value

    def _heapify_up(self, index):
        parent_index = (index - 1) // 2
        if index <= 0:
            return
        elif self.heap[parent_index] > self.heap[index]:
            self.heap[parent_index], self.heap[index] = self.heap[index], self.heap[parent_index]
            self._heapify_up(parent_index)

    def _heapify_down(self, index):
        left_child_index = (2 * index) + 1
        right_child_index = (2 * index) + 2
        smallest = index

        if (
            left_child_index < len(self.heap)
            and self.heap[left_child_index] < self.heap[smallest]
        ):
            smallest = left_child_index

        if (
            right_child_index < len(self.heap)
            and self.heap[right_child_index] < self.heap[smallest]
        ):
            smallest = right_child_index

        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)

    def peek(self):
        return self.heap[0]

def main():
    t = int(input())
    pqmax = PriorityQueue()
    pqmin = PriorityQueue()
    sumMin, sumMax, sumb = 0, 0, 0
    min = float("inf")

    for _ in range(t):
        s = input().split()

        if s[0][0] == "2":
            ans = min * len(pqmin.heap)
            ans -= sumMin
            ans1 = min * len(pqmax.heap)
            ans1 = sumMax - ans1
            print(min, (ans + ans1 + sumb))

        else:
            in_val = int(s[1])
            sumb += float(s[2])

            if in_val > min:
                pqmax.push(in_val)
                sumMax += in_val

            else:
                pqmin.push(in_val)
                sumMin += in_val

            if len(pqmin.heap) > len(pqmax.heap):
                sumMax += pqmin.peek()
                sumMin -= pqmin.peek()
                pqmax.push(pqmin.pop())

            elif len(pqmin.heap) < len(pqmax.heap):
                sumMax -= pqmax.peek()
                sumMin += pqmax.peek()
                pqmin.push(pqmax.pop())

            min = float("inf")
            if pqmin.heap:
                min = pqmin.peek()

if __name__ == "__main__":
    main()
