package com.example;
import java.util.List;
import java.util.NoSuchElementException;

public class HumanEval_35 {
    /**
     * Return maximum element in the list.
     *
     * @param l The list of numbers.
     * @return The maximum element in the list.
     * @throws NoSuchElementException if the list is empty.
     * @throws IllegalArgumentException if the list contains non-numeric types (implicitly handled by stream/doubleValue conversion if we assume List<Number> input).
     */
    public static double maxElement(List<? extends Number> l) {
        if (l == null || l.isEmpty()) {
            throw new NoSuchElementException("List cannot be empty.");
        }

        // The Python code asserts inputs are int or float. In Java, we rely on the List<Number> interface
        // and convert to double for comparison, which handles int and float correctly.
        return l.stream()
                .mapToDouble(Number::doubleValue)
                .max()
                .getAsDouble();
    }
}