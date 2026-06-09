import sys

class atcoder_ABC133_E:
    class Node:
        def __init__(self, i):
            self.pattern = 0
            self.index = i
            self.children = []
            self.parent = -1

        def set_parent(self, K, parent, use, nodes):
            # Calculate pattern: K - use
            self.pattern = K - use
            self.parent = parent
            
            # Initialize count
            count = 1
            if parent != -1:
                count += 1
            
            # Traverse children
            for n in self.children:
                if n == self.parent:
                    continue
                
                # Recursive call
                nodes[n].set_parent(K, self.index, count, nodes)
                
                # Increment count for the next child
                count += 1

    def solve(self):
        # Read N and K
        try:
            data = sys.stdin.read().split()
            if not data:
                return
            
            N = int(data[0])
            K = int(data[1])
            
            # Initialize nodes array
            nodes = [self.Node(i) for i in range(N)]
            
            # Read edges
            data_index = 2
            for _ in range(N - 1):
                # Input is 1-based, convert to 0-based
                a = int(data[data_index]) - 1
                b = int(data[data_index + 1]) - 1
                data_index += 2
                
                nodes[a].children.append(b)
                nodes[b].children.append(a)
        except Exception as e:
            # Handle potential EOF or formatting errors gracefully
            return

        # Start the traversal from node 0
        # K: constant, parent: -1 (root), use: 0 (initial count)
        nodes[0].set_parent(K, -1, 0, nodes)

        # Calculate the product of patterns modulo 10^9 + 7
        MOD = 1_000_000_007
        patterns = 1
        for i in range(N):
            patterns = (patterns * nodes[i].pattern) % MOD
        
        print(patterns)

def main():
    atcoder_ABC133_E().solve()

if __name__ == "__main__":
    main()