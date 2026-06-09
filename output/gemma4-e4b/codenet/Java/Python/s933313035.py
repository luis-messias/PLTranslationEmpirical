import sys

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, new_value):
        # BST insertion logic: smaller goes left, larger/equal goes right
        if new_value < self.value:
            if self.left is None:
                self.left = Node(new_value)
            else:
                self.left.insert(new_value)
        else:
            if self.right is None:
                self.right = Node(new_value)
            else:
                self.right.insert(new_value)

    def print_in_order(self):
        if self.left:
            self.left.print_in_order()
        
        # Print format: " " + value
        print(f" {self.value}", end="")
        
        if self.right:
            self.right.print_in_order()

    def print_pre_order(self):
        # Print format: " " + value
        print(f" {self.value}", end="")
        
        if self.left:
            self.left.print_pre_order()
        
        if self.right:
            self.right.print_pre_order()

def main():
    # Read all tokens from standard input
    try:
        data = sys.stdin.read().split()
    except EOFError:
        data = []

    if not data:
        return

    # The first element is m, the number of commands
    try:
        m = int(data[0])
    except ValueError:
        return # Handle case where m is not an integer

    # Initialize the tree root
    tree = None
    
    # Index tracker for reading tokens
    data_index = 1
    
    for i in range(m):
        if data_index >= len(data):
            break
            
        command = data[data_index]
        data_index += 1

        if command == "insert":
            if data_index >= len(data):
                break
            try:
                key = int(data[data_index])
            except ValueError:
                data_index += 1
                continue
            data_index += 1

            if tree is None:
                tree = Node(key)
            else:
                tree.insert(key)
        
        elif command in ["printInOrder", "printPreOrder"]:
            # This block handles the case where the command is executed
            # and requires printing, but the input structure suggests
            # that the commands themselves are the actions, not the arguments.
            # The original Java code structure implies that if the command 
            # is NOT "insert", it executes the print operations.
            pass # The logic below handles the execution flow

    # Re-implementing the main loop logic based on the Java structure:
    # The Java code reads M commands. If the command is "insert", it processes it.
    # If the command is anything else (implicitly, the print command), it executes prints.
    
    # Since we processed the input sequentially above, we need to re-read or adjust the loop.
    # Let's reset the input processing to match the Java flow exactly:
    
    data_index = 1
    tree = None
    
    for i in range(m):
        if data_index >= len(data):
            break
            
        command = data[data_index]
        data_index += 1

        if command == "insert":
            if data_index >= len(data):
                break
            try:
                key = int(data[data_index])
            except ValueError:
                data_index += 1
                continue
            data_index += 1

            if tree is None:
                tree = Node(key)
            else:
                tree.insert(key)
        else:
            # This branch executes if the command is NOT "insert"
            if tree is not None:
                # printInOrder
                tree.print_in_order()
                print() # Newline after printInOrder
                
                # printPreOrder
                tree.print_pre_order()
                print() # Newline after printPreOrder

if __name__ == "__main__":
    main()