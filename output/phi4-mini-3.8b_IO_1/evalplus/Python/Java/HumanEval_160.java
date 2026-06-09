package com.example;
public class HumanEval_160 {

    public static int doAlgebra(String[] operators, int[] operands) {
        StringBuilder expression = new StringBuilder();
        
        for (int i = 0; i < operators.length - 1; i++) { // One less than the length of operand array.
            expression.append(operands[i]);
            expression.append(" ").append(operators[i]).append(" ");
        }
        
        expression.append(operands[operands.length - 1]); // Last element in operands
        
        return evaluateExpression(expression.toString());
    }

    private static int evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if ("+-*/**".indexOf(token) != -1) { // Check operator
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token.charAt(0)) { // Determine operation based on first character of the operator.
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/': 
                        if (b == 0) throw new IllegalArgumentException("Division by zero is not allowed.");
                        stack.push(a / b); // Floor division equivalent in Java
                        break;
                    case '**':
                        stack.push((int)Math.pow(a, b));
                        break;
                }
            } else { // Must be an operand.
                stack.push(Integer.parseInt(token.trim()));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] operators = {"+", "*", "-"};
        int[] operands = {2, 3, 4, 5};
        
        System.out.println(doAlgebra(operators, operands)); // Output: 9
    }
}
