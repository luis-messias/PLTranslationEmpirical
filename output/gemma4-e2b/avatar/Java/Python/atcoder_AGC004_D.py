import sys

class Calculator:
    def __init__(self, n, k, as_list):
        self.k = k
        self.lists = [[] for _ in range(n)]
        self.answer = 0

        # Build the adjacency list based on as_list
        for i in range(n):
            j = as_list[i]
            if i > 0:
                # Java: if (0 < i) { this.lists.get(j).add(i); }
                # Note: The Java logic seems slightly complex regarding indices.
                # If as[i] = j, it connects node j to node i.
                # The Java code iterates i=0..n-1. j = as.get(i).
                # If i > 0, it adds i to lists.get(j).
                self.lists[j].append(i)
            else:
                # Java: else if (0 < j) { this.answer ++ ; }
                # This condition seems to be: if i=0, j=as[0]. If as[0] > 0, increment answer.
                # This part is tricky based on the Java structure:
                # for ( int i = 0 ; i < n ; i ++ ) { int j = as.get(i) ; if ( 0 < i ) { this.lists.get(j ).add( i ) ; } else if ( 0 < j ) { this.answer ++ ; } }
                # Let's re-examine the Java loop structure:
                # for ( int i = 0 ; i < n ; i ++ ) { int j = as.get(i) ; if ( 0 < i ) { this.lists.get(j ).add( i ) ; } else if ( 0 < j ) { this.answer ++ ; } }
                # This loop iterates over the input array 'as'.
                # i is the index of the element being processed (0 to n-1).
                # j is the value in as[i] (which is 0 to n-1, since inputs are -1 to n-1).
                
                # Re-implementing the loop based on the Java structure:
                pass # The logic is handled below in the main flow if we assume the constructor logic is correct.

        # Re-evaluating the Java constructor logic:
        # for ( int i = 0 ; i < n ; i ++ ) { int j = as.get(i) ; if ( 0 < i ) { this.lists.get(j ).add( i ) ; } else if ( 0 < j ) { this.answer ++ ; } }
        
        # Let's stick to the interpretation that the input reading handles the setup correctly, 
        # and the constructor sets up the graph structure based on the input array 'as'.
        
        # The Java code seems to have a bug or unusual structure in how it builds the graph and counts 'answer' inside the constructor.
        # I will translate the structure exactly, assuming the intent is to replicate the behavior.
        
        # Re-implementing the graph building based on the provided Java snippet:
        self.lists = [[] for _ in range(n)]
        self.answer = 0
        
        for i in range(n):
            j = as_list[i]
            if i > 0:
                # This part seems to be adding edges based on the index i and the value as_list[i]
                # If i > 0, add i to lists[as_list[i]]
                if j < n: # Ensure j is a valid index
                    self.lists[j].append(i)
            elif j > 0:
                # If i == 0, check if j > 0. If so, increment answer.
                self.answer += 1


    def calculate(self):
        if not self.isCalculate:
            self.dfs(0, 0)
            self.isCalculate = True
        return self.answer

    def dfs(self, a, pre):
        h = 0
        # Iterate over neighbors in lists[a]
        for i in self.lists[a]:
            h = max(h