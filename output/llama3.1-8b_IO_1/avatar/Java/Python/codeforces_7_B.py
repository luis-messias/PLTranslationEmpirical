import sys

class Memory:
    def __init__(self, m):
        self.memory = [0] * m
        self.alloc_idx = 0

    def alloc(self, n):
        can_alloc = False
        len_ = 0
        for i in range(len(self.memory)):
            if self.memory[i] == 0:
                len_ += 1
            else:
                len_ = 0
            if len_ == n:
                can_alloc = True
                len_ = i - n + 1
                break
        if can_alloc:
            for i in range(len_, len_ + n):
                self.memory[i] = self.alloc_idx
            print(self.alloc_idx)
            self.alloc_idx += 1
        else:
            print("NULL")

    def erase(self, x):
        if x <= 0:
            print("ILLEGAL_ERASE_ARGUMENT")
            return
        has_erased = False
        for i in range(len(self.memory)):
            if self.memory[i] == x:
                self.memory[i] = 0
                has_erased = True
        if not has_erased:
            print("ILLEGAL_ERASE_ARGUMENT")

    def defragment(self):
        d = 0
        for i in range(len(self.memory)):
            if self.memory[i] == 0:
                d += 1
            else:
                self.memory[i - d] = self.memory[i]
        for i in range(len(self.memory) - d, len(self.memory)):
            self.memory[i] = 0

def main():
    scanner = sys.stdin.readline
    t = int(scanner().split()[0])
    m = int(scanner().split()[1])
    memory = Memory(m)
    for _ in range(t):
        op = scanner().strip()
        if op == "alloc":
            n = int(scanner().split()[1])
            memory.alloc(n)
        elif op == "erase":
            x = int(scanner().split()[1])
            memory.erase(x)
        elif op == "defragment":
            memory.defragment()
        else:
            print("h")

if __name__ == "__main__":
    main()
