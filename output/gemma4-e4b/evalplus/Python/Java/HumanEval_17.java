package com.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    /**
     * Input to this function is a string representing musical notes in a special ASCII format.
     * Your task is to parse this string and return list of integers corresponding to how many beats does each
     * not last.
     *
     * @param musicString The string containing musical notes separated by spaces.
     * @return A list of integers representing the beat count for each note.
     */
    public List<Integer> parseMusic(String musicString) {
        if (musicString == null || musicString.isEmpty()) {
            return java.util.Collections.emptyList();
        }

        String[] notes = musicString.split(" ");

        // Use Java Streams to map each note string to its beat count
        return Arrays.stream(notes)
                     .map(this::countBeats)
                     .collect(Collectors.toList());
    }

    /**
     * Helper function to determine the beat count for a given note string.
     */
    private int countBeats(String note) {
        if (note == null) {
            return 0;
        }
        switch (note) {
            case "o":
                return 4;
            case "o|":
                return 2;
            case ".|":
                return 1;
            default:
                // Should not happen based on problem constraints
                return 0;
        }
    }
}