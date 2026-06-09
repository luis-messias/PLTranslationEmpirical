import sys

class UnionFind:
    def __init__(self, n):
        self.parent = [-1] * (n)
    
    def root(self, A):
        if self.parent[A] < 0:
            return A
        else:
            while True:
                parent_A = self.root(self.parent[A])
                if parent_A == -1 or parent_A != A:
                    break
                A = parent_A

    def size(self, A):
        root_A = self.root(A)
        count = 0
        for i in range(len(self.parent)):
            if (self.parent[i] < 0 and 
               self.find(i) == root_A): 
                count += -1 * self.parent[i]
        return count

    def connect(self, A, B):
        A_root = self.root(A)
        B_root = self.root(B)

        if A_root != B_root:
            if (self.size(A_root) < self.size(B_root)):
                C, D = 0, 1
            else: 
                C, D = 1, 0

            parent_A, parent_B = -C * (-A + 2), -D * (B + 2)
            A_parent, B_parent = -parent_A / self.size(A_root) if A_root == root_A else -self.parent[A]
            B_parent += D
            C -= 1

        return True


if __name__ == "__main__":
    input_data = sys.stdin.read()
    
    lines = input_data.split('\n')
    for line in lines:
        parts = list(map(int, line.strip().split()))