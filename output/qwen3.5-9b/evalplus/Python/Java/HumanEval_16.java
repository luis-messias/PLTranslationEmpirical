package com.example;
public int countDistinctCharacters(String string) {
    Set<Character> distinctChars = new HashSet<>();
    for (char c : string.toLowerCase().toCharArray()) {
        distinctChars.add(c);
    }
    return distinctChars.size();
}