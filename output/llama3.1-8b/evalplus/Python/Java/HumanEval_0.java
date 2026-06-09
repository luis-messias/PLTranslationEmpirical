package com.example;
import java.util.Arrays;

public class HumanEval_0 {
    public static boolean hasCloseElements(float[] numbers, float threshold) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] < threshold) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        float[] numbers1 = {1.0f, 2.0f, 3.0f};
        System.out.println(hasCloseElements(numbers1, 0.5f));
        
        float[] numbers2 = {1.0f, 2.8f, 3.0f, 4.0f, 5.0f, 2.0f};
        System.out.println(hasCloseElements(numbers2, 0.3f));
    }
}