package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_17 {
    public static List<Integer> parseMusic(String musicString) {
        if (musicString.isEmpty()) return new ArrayList<>();

        String[] notes = musicString.split(" ");
        List<Integer> beats = new ArrayList<>();
        
        for (String note : notes) {
            if (note.equals("o")) beats.add(4);
            else if (note.equals("o|")) beats.add(2);
            else if (note.equals(".|")) beats.add(1);
        }
        
        return beats;
    }

    public static void main(String[] args) {
        System.out.println(parseMusic("o o| .|. o| o| .|. .|. .|. .|. o o"));
    }
}