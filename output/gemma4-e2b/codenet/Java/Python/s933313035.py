import sys

class Node:
    def __init__(self):
        self.value = None
        self.left = None
        self.right = None

    def insert(self, newValue):
        if newValue < self.value:
            if self.left is None:
                self.left = Node()
                self.left.value = newValue
            else:
                self.left.insert(newValue)
        else:
            # Handles newValue >= self.value (duplicates go to the right)
            if self.right is None:
                self.right = Node()
                self.right.value = newValue
            else:
                self.right.insert(newValue)

    def printInOrder(self):
        if self.left is not None:
            self.left.printInOrder()
        print(" " + str(self.value))
        if self.right is not None:
            self.right.printInOrder()

    def printPreOrder(self):
        print(" " + str(self.value))
        if self.left is not None:
            self.left.printPreOrder()
        if self.right is not None:
            self.right.printPreOrder()

def main():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # The first token is m
    try:
        m = int(data[0])
    except ValueError:
        return

    if m == 0:
        return

    tree = None
    data_index = 1

    for _ in range(m):
        if data_index >= len(data):
            break
            
        command = data[data_index]
        data_index += 1

        if command == "insert":
            if data_index >= len(data):
                break
            try:
                key = int(data[data_index])
                data_index += 1
            except ValueError:
                # Handle case where key is missing or invalid
                continue

            if tree is None:
                tree = Node()
                tree.value = key
            else:
                tree.insert(key)
        else:
            if tree is not None:
                # Print InOrder
                # Note: The Java implementation prints the value immediately, 
                # which means the recursive calls handle the printing.
                # We need to ensure the printing logic matches the Java output structure.
                
                # Since the Java implementation calls printInOrder() and then prints a newline, 
                # we need to adapt the recursive printing to handle the output correctly.
                
                # To match the Java behavior where printInOrder() prints the sequence:
                
                # We need a helper function or modify the Node methods to handle printing directly 
                # without relying on the main loop structure to manage the flow, 
                # or ensure the recursive calls print correctly.
                
                # Let's redefine the printing to be cleaner for the main loop context.
                
                # Reverting to the original recursive structure for printing:
                
                # We need a way to capture the output of the traversal.
                
                # Since the Java code prints directly inside the methods, we must replicate that.
                
                # To avoid printing during the loop iteration, we must ensure the printing 
                # happens exactly as intended by the Java code structure.
                
                # The Java code calls printInOrder() and then prints a newline.
                
                # Since the Node methods print directly, we just call them.
                tree.printInOrder()
                print()
                tree.printPreOrder()
                print()


if __name__ == "__main__":
    main()