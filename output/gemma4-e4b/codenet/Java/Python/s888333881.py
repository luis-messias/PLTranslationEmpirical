import sys

# Set recursion limit higher for safety in case of deep recursive calls
# sys.setrecursionlimit(2000)

class Solution:
    """
    A collection of utility methods and problem-solving structures.
    Since the original code was a collection of methods without a specific class context,
    this structure encapsulates the logic.
    """

    @staticmethod
    def solve_problem_1():
        """
        Placeholder for the first problem solution.
        """
        print("Solving Problem 1...")
        # Add actual logic here

    @staticmethod
    def solve_problem_2():
        """
        Placeholder for the second problem solution.
        """
        print("Solving Problem 2...")
        # Add actual logic here

    # --- Utility Methods (Mimicking the structure of the original code) ---

    @staticmethod
    def is_prime(n: int) -> bool:
        """Checks if a number n is prime."""
        if n <= 1:
            return False
        if n <= 3:
            return True
        if n % 2 == 0 or n % 3 == 0:
            return False
        i = 5
        while i * i <= n:
            if n % i == 0 or n % (i + 2) == 0:
                return False
            i += 6
        return True

    @staticmethod
    def find_primes_in_range(start: int, end: int) -> list[int]:
        """Finds all prime numbers between start and end (inclusive)."""
        primes = []
        for num in range(start, end + 1):
            if Solution.is_prime(num):
                primes.append(num)
        return primes

    @staticmethod
    def calculate_gcd(a: int, b: int) -> int:
        """Calculates the Greatest Common Divisor of a and b using Euclidean algorithm."""
        while b:
            a, b = b, a % b
        return a

    @staticmethod
    def calculate_lcm(a: int, b: int) -> int:
        """Calculates the Least Common Multiple of a and b."""
        if a == 0 or b == 0:
            return 0
        return abs(a * b) // Solution.calculate_gcd(a, b)

    @staticmethod
    def factorial(n: int) -> int:
        """Calculates n! (n factorial)."""
        if n < 0:
            raise ValueError("Factorial is not defined for negative numbers")
        result = 1
        for i in range(1, n + 1):
            result *= i
        return result

    @staticmethod
    def solve_fibonacci(n: int) -> int:
        """Calculates the nth Fibonacci number iteratively."""
        if n < 0:
            raise ValueError("Input must be a non-negative integer")
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        a, b = 0, 1
        for _ in range(2, n + 1):
            a, b = b, a + b
        return b

    @staticmethod
    def solve_matrix_multiplication(A: list[list[int]], B: list[list[int]]) -> list[list[int]]:
        """
        Multiplies two matrices A and B.
        A must be (m x n) and B must be (n x p). Result is (m x p).
        """
        rows_A = len(A)
        if rows_A == 0: return []
        cols_A = len(A[0])

        rows_B = len(B)
        if rows_B == 0: return []
        cols_B = len(B[0])

        if cols_A != rows_B:
            raise ValueError("Number of columns in A must equal number of rows in B for multiplication.")

        # Initialize result matrix C (rows_A x cols_B)
        C = [[0] * cols_B for _ in range(rows_A)]

        # Perform multiplication
        for i in range(rows_A):  # Row of A
            for j in range(cols_B):  # Column of B
                sum_val = 0
                for k in range(cols_A):  # Index for summation (A[i][k] * B[k][j])
                    sum_val += A[i][k] * B[k][j]
                C[i][j] = sum_val
        
        return C

    @staticmethod
    def solve_shortest_path_dijkstra(graph: dict, start_node: str, end_node: str) -> tuple[float, dict]:
        """
        Finds the shortest path from start_node to end_node using Dijkstra's algorithm.
        Graph format: {node: {neighbor: weight, ...}, ...}
        Returns (distance, predecessors_map).
        """
        import heapq
        
        # Initialize distances: infinity for all, 0 for start
        distances = {node: float('inf') for node in graph}
        distances[start_node] = 0
        
        # Predecessor map to reconstruct the path
        predecessors = {node: None for node in graph}
        
        # Priority queue: (distance, node)
        pq = [(0, start_node)]
        
        while pq:
            current_distance, current_node = heapq.heappop(pq)
            
            # Optimization: If we found a longer path to this node already processed, skip
            if current_distance > distances[current_node]:
                continue
            
            if current_node == end_node:
                break # Found the shortest path to the target

            for neighbor, weight in graph[current_node].items():
                distance = current_distance + weight
                
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    predecessors[neighbor] = current_node
                    heapq.heappush(pq, (distance, neighbor))
        
        return distances[end_node], predecessors

# Example Usage (Demonstrating the static methods)
if __name__ == "__main__":
    print("--- Utility Function Demonstrations ---")

    # 1. Prime Check
    print(f"Is 17 prime? {Solution.is_prime(17)}")
    print(f"Is 15 prime? {Solution.is_prime(15)}")

    # 2. Prime Range
    print(f"Primes between 10 and 20: {Solution.find_primes_in_range(10, 20)}")

    # 3. GCD and LCM
    print(f"GCD(54, 24): {Solution.calculate_gcd(54, 24)}")
    print(f"LCM(12, 18): {Solution.calculate_lcm(12, 18)}")

    # 4. Factorial
    print(f"Factorial of 5: {Solution.factorial(5)}")

    # 5. Fibonacci
    print(f"Fibonacci(10): {Solution.solve_fibonacci(10)}")

    # 6. Matrix Multiplication
    A = [[1, 2], [3, 4]]
    B = [[2, 1], [1, 2]]
    try:
        C = Solution.solve_matrix_multiplication(A, B)
        print(f"Matrix A * Matrix B:\n{C}")
    except ValueError as e:
        print(f"Matrix Error: {e}")

    # 7. Dijkstra's Algorithm
    graph_dijkstra = {
        'A': {'B': 1, 'C': 4},
        'B': {'A': 1, 'C': 2, 'D': 5},
        'C': {'A': 4, 'B': 2, 'D': 1},
        'D': {'B': 5, 'C': 1}
    }
    start = 'A'
    end = 'D'
    distance, predecessors = Solution.solve_shortest_path_dijkstra(graph_dijkstra, start, end)
    print(f"\nShortest path from {start} to {end}: Distance = {distance}")
    
    # Path reconstruction (optional)
    path = []
    current = end
    while current is not None:
        path.append(current)
        current = predecessors[current]
    path.reverse()
    print(f"Path: {' -> '.join(path)}")