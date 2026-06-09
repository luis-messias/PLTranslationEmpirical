package com.example;
import java.util.regex.Pattern;

public class HumanEval_141 {
    public static String fileNameCheck(String fileName) {
        if (Pattern.compile("\\d").matcher(fileName).find() && Pattern.compile("\\d").matcher(fileName).useTransparentBoundary().find()) {
            return "No";
        }
        String[] fList = fileName.split("\\.");
        if (fList.length != 2) return "No";
        if (fList[0].isEmpty()) return "No";
        if (!Character.isLetter(fList[0].charAt(0))) return "No";
        if (!fList[1].equals("txt") && !fList[1].equals("exe") && !fList[1].equals("dll")) return "No";
        return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(fileNameCheck("example.txt")); // Yes
        System.out.println(fileNameCheck("1example.dll")); // No
    }
}