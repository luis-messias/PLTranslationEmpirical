package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_105 {
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        // Add elements to 'arr' as needed for testing
        
        String result = processArray(arr);
        
        System.out.println(result);  // Print the processed list
    }

    private static String processArray(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return "";

        List<String> sortedList, ans;
        Collections.sort(arr);

        int i = 0, j = arr.size() - 1;
        while(i <= j){
            Integer x = arr.get(i);
            String word;

            switch(x) {
                case 1: word = "One"; break;
                case 2: word = "Two"; break;
                case 3: word = "Three"; break;
                case 4: word = "Four"; break;
                case 5: word = "Five"; break;
                case 6: word = "Six"; break;
                case 7: word = "Seven"; break;
                case 8: word = "Eight"; break;
                default:
                    if(x == -1 || x > 9) {
                        i++;
                        continue; // Skip invalid numbers
                    }
                    word = toWord(x);
            }

            ans.add(word);

            while(i <= j && arr.get(j).equals(arr.get(i))){
                String nextWord;

                switch(arr.get(j)){
                    case 1: nextWord = "One"; break;
                    case 2: nextWord = "Two"; break;
                    case 3: nextWord = "Three"; break;
                    case 4: nextWord = "Four"; break;
                    case 5: nextWord = "Five"; break;
                    case 6: nextWord = "Six"; break;
                    case 7: nextWord = "Seven"; break;
                    case 8: nextWord = "Eight"; break;
                }

                if(nextWord.equals(word)){
                    j--;
                } else {
                    ans.add(toWord(arr.get(i)));
                    i++;
                }
            }
        }

        return String.join(" ", ans);
    }

    private static String toWord(int x) {
        switch(x){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            default:
                if(x == -1 || x > 9) {
                    throw new IllegalArgumentException("Invalid number");
                }
                break;
        }

        return "";
    }
}