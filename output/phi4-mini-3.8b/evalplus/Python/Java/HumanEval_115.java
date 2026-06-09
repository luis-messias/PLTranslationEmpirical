package com.example;
import java.util.List;

public class HumanEval_115 {

    public static int maxFill(List<List<Integer>> grid, int bucketCapacity) {

        int totalOperations = 0;    

        for (List<Integer> row : grid) { 

            long sumOfWells = Long.parseLong(row.stream().mapToInt(Integer::parseInt).sum());

            if(sumOfWells > 0){

                totalOperations += (int)Math.ceil((double)sumOfWells / bucketCapacity);

            }

        }    

        return totalOperations;

    }


}