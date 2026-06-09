package com.example;
import java.util.List;

import java.util.ArrayList;


public class HumanEval_8 {

    public static Tuple sum_product(List<Integer> numbers) {

        int sum = 0;
        long product = 1; // Using Long for larger range of products


        if (numbers == null || numbers.isEmpty()) {

            return new Tuple(0, 1);

        }


        for (Integer number : numbers) {

            sum += number;

            product *= number;

        }

        return new Tuple(sum, product);


    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println("Empty: " + SumProduct.sum_product(list));

        list.add(1);

        list.add(2);

        list.add(3);
        list.add(4);

        System.out.println("Non-empty: " + SumProduct.sum_product(list));

    }


}


class Tuple {

    int first;

    long second;


    public Tuple(int first, long second) {

        this.first = first;

        this.second = second;

    }

}