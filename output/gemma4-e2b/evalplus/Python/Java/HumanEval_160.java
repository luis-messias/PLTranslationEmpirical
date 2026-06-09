package com.example;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class HumanEval_160 {
    public static double doAlgebra(List<String> operator, List<Integer> operand) {
        StringBuilder exp = new StringBuilder();

        for (int i = 0; i < operator.size(); i++) {
            exp.append(operand.get(i)).append(operator.get(i));
        }
        exp.append(operand.get(operand.size() - 1));

        String expression = exp.toString();

        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(expression);
            return ((Number) result).doubleValue();
        } catch (Exception e) {
            // In a real application, error handling would be more robust.
            // For this translation, we rely on the assumption that the input adheres to the rules.
            throw new RuntimeException("Error evaluating algebraic expression: " + expression, e);
        }
    }
}