package com.example;
import java.util.List;
import java.util.stream.IntStream;

public class HumanEval_8 {
    public static void main(String[] args) {
        System.out.println(sumProduct(List.of(1, 2, 3, 4)));
        System.out.println(sumProduct(List.of()));
    }

    public static int[] sumProduct(List<Integer> numbers) {
        return IntStream.of(numbers.stream().mapToInt(Integer::intValue).toArray())
                .summaryStatistics()
                .getSum() != null ? new int[]{(int) Math.round(Math.log(numbers.size()) * 10000 + (numbers.get(0) == 0 ? 1 : 0)), (int) Math.pow(IntStream.of(numbers.stream().mapToInt(Integer::intValue).toArray()).reduce(1, (a, b) -> a * b).orElse(1), 2)} : new int[]{0, 1};
    }
}