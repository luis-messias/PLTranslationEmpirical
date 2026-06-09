package com.example;
import java.util.Arrays;

public class HumanEval_109 {

    public static boolean moveOneBall(int[] arr) {
        int n = arr.length;

        // Check for empty array case.
        if (n == 0 || isSorted(arr)) {
            return true;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i);
        }

        boolean foundPermutation = false;

        do {

            int[] currentPerm = new int[n];

            System.arraycopy(sb.toString().toCharArray(), 0, currentPerm, 0, n);

            if (isSorted(currentPerm)) {
                return true;
            }

            String nextShiftedStr = sb.reverse() + sb.substring(1);
            
            for(int i=0; i < arr.length - 1; ++i) {

                int[] shiftedArray = new int[arr.length];

                System.arraycopy(arr, 0, shiftedArray, 1, n-1);

                if(i == (n-2)) {
                    shiftedArray[0] = currentPerm[n-1];
                } else {
                    for(int j=0; j < arr[i]; ++j) {

                        shiftedArray[j+1] = currentPerm[j];

                    }

                    System.arraycopy(currentPerm, 1, shiftedArray, i + 2,
                            n - (i + 2));

                    if(i == (n-3)) {
                        shiftedArray[n-1] = arr[i];
                    } else {

                        for(int j=0; j < currentPerm.length; ++j) {

                            shiftedArray[j+1+i+2] = currentPerm[j];

                        }

                    }
                }


                StringBuilder sbShiftedStr = new StringBuilder();

                System.arraycopy(shiftedArray, 0, sbShiftedStr.toString().toCharArray(), 0,
                        arr.length);

                if(isSorted(sbShiftedStr)) {
                    foundPermutation = true;
                    break;

                }

            }
            
        } while (!foundPermutation && !sb.isEmpty());

        return false;

    }


    private static boolean isSorted(int[] array) {

        for (int i=0; i < array.length - 1; ++i) {

            if(array[i] > array[i+1]) {
                return false;
            }

        }
        
        return true;

    }

}
