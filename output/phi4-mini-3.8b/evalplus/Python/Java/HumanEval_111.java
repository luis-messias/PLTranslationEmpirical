package com.example;
import java.util.HashMap;

public class HumanEval_111 {

    public static HashMap<Character, Integer> histogram(String test) {

        // Return an empty map for null or empty input string.
        if (test == null || test.isEmpty()) return new HashMap<>();

        HashMap<Character, Integer> count = new HashMap<>();
        String[] words = test.split(" ");

        for (String word : words) {
            char firstChar = Character.toLowerCase(word.charAt(0));
            int occurrencesInWord = 1;

            while (++word.indexOf(firstChar, word.length()) != -1) {

                if (!count.containsKey(firstChar)) count.put(firstChar, 0);
                count.put(firstChar, count.get(firstChar) + (occurrencesInWord / Character.toCount(firstChar)));
            }

        }
        
        int maxOccurrences = Collections.max(count.values());

        HashMap<Character, Integer> result = new HashMap<>();
        for (Character key : count.keySet()) {
            if (count.get(key).equals(maxOccurrences)) {

                // In case of ties in occurrences, we need to store all characters with the same occurrence.
                int currentCount;

                do {

                    StringBuilder sb = new StringBuilder();
                    char ch;
                    while ((ch = result.pollFirstEntry().getKey()) != null) {
                        if (sb.length() > 0 && Character.toLowerCase(ch).charAt(0) == key.charAt(0)) continue; // Skip characters that are already in the sb.
                        sb.append(ch);
                    }
                    ch = new StringBuilder(sb.toString()).reverse().toCharArray()[0];
                    if (ch != null) result.put(ch, count.get(key));
                } while ((currentCount = Collections.max(result.values())) == maxOccurrences);

            }

        return result;

    }


}