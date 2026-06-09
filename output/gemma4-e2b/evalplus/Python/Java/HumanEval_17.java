package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_17 {

    public List<Integer> parseMusic(String musicString) {
        if (musicString == null || musicString.isEmpty()) {
            return new ArrayList<>();
        }

        // Split the string by space to get individual note tokens
        String[] notes = musicString.split(" ");
        List<Integer> result = new ArrayList<>();

        for (String note : notes) {
            if (note.equals("o")) {
                result.add(4); // whole note
            } else if (note.equals("o|")) {
                result.add(2); // half note
            } else if (note.equals(".|")) {
                result.add(1); // quarter note
            }
            // Assuming input only contains the defined note types based on the Python logic
        }

        return result;
    }
}