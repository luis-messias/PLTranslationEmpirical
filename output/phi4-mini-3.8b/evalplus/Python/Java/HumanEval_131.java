package com.example;
public class HumanEval_131 {

    public static void main(String[] args) {
        System.out.println(digits(1)); // Output: 1
        System.out.println(digits(4)); // Output: 0

        int result = digits("235");
        if (result == -1)
            System.out.println("All even");

        else {

            StringBuilder sb = new StringBuilder();

            for(int i=2; i<result+2; ++i) {
                char c = ('0' + ((result % 10)));
                sb.append(c);

            }

            System.out.println(result); // Output: 15

        }
    }


    public static int digits(String nStr){

        boolean hasOdd, prod;

        if(nStr == null || nStr.length() <= 1) return -1;


        String str = Integer.toString(Integer.parseInt(nStr));

        for(int i=0; i < str.length(); ++i){
            char ch = Character.forDigit(str.charAt(i),10);

            int num = Character.digit(ch, 10);
            
            if(num % 2 == 1) {
                hasOdd = true;
                prod *= num;

            } else {

                return -1; // Return early as all digits are even

            }

        }
        
        return (hasOdd ? prod : 0);

    }


}