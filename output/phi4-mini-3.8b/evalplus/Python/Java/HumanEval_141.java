package com.example;
public class HumanEval_141 {

    public static String file_name_check(String fileName) {
        int digitCount = 0;
        for (char ch : fileName.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }

        String[] f_list = fileName.split("\\.");
        if (f_list.length != 2 || digitCount > 3) return "No";
        
        char firstLetter = Character.toLowerCase(f_list[0].charAt(0));
        if (!Character.isAlphabetic(firstLetter)) return "No";

        String extension = f_list[1];
        switch(extension) {
            case "txt":
            case "exe":
            case "dll": break;
            default: return "No";
        }

        return "Yes";
    }
}