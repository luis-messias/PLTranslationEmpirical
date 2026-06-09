package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_160 {
    public static int doAlgebra(String[] operators, List<Integer> operands) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < operators.length; i++) {
            expression.append(operands.get(i)).append(operators[i]);
        }
        expression.append(operands.get(operands.size() - 1));
        try {
            return Integer.parseInt(expression.toString());
        } catch (NumberFormatException e) {
            // If the expression is not a valid number, use JavaScript engine to evaluate it
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("js");
            try {
                return Integer.parseInt(engine.eval(expression.toString()).toString());
            } catch (javax.script.ScriptException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        String[] operators = {"+", "*", "-"};
        List<Integer> operands = new ArrayList<>();
        operands.add(2);
        operands.add(3);
        operands.add(4);
        operands.add(5);
        System.out.println(doAlgebra(operators, operands));
    }
}