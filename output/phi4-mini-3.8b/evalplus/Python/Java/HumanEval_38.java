package com.example;
public class HumanEval_38 {

    public static String encodeCyclic(String s) {
        int length = s.length();
        char[] resultArray = new char[length];
        
        // split string into groups of 3 characters.
        for (int i = 0; i < Math.ceil(length / 3.0); i++) {
            if ((i * 3 + 2) > length)
                break;
            
            String group = s.substring(i * 3, Math.min((i+1)*3, length));
            // cycle elements in each group unless the last one has fewer than three characters.
            char[] newGroupArray = new char[group.length()];
            for (int j = 0; j < group.length(); j++) {
                if ((j + 2) >= group.length())
                    break;
                
                int shiftedIndex = (j + 1) % 3;
                newGroupArray[shiftedIndex] = group.charAt(j);
            }
            
            resultArray[i * 3 : i * 3 + Math.min((i+1)*3, length)] = newGroupArray;
        }

        return String.valueOf(resultArray).substring(0, s.length());
    }

    public static String decodeCyclic(String encoded) {
        int length = encoded.length();
        char[] resultArray = new char[length];
        
        // split string into groups of 3 characters.
        for (int i = 0; i < Math.ceil(length / 3.0); i++) {
            if ((i * 3 + 2) > length)
                break;
            
            String group = encoded.substring(i * 3, Math.min((i+1)*3, length));
            // cycle elements in each group unless the last one has fewer than three characters.
            char[] newGroupArray = new char[group.length()];
            for (int j = 0; j < group.length(); j++) {
                if ((j + 2) >= group.length())
                    break;
                
                int shiftedIndex = (j + 1) % 3;
                newGroupArray[j] = group.charAt(shiftedIndex);
            }
            
            resultArray[i * 3 : i * 3 + Math.min((i+1)*3, length)] = newGroupArray;
        }

        return String.valueOf(resultArray).substring(0, encoded.length());
    }

}