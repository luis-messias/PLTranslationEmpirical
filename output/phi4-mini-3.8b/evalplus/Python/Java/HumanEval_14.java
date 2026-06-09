package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_14 {

    public static List<String> allPrefixes(String string) {
        List<String> result = new ArrayList<>();
        String prefix = "";
        
        for (int i = 0; i < string.length(); i++) {
            prefix += string.charAt(i);
            result.add(prefix);
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<String> prefixes = allPrefixes("abc");
        System.out.println(prefixes); // Output: [a, ab, abc]
    }
}