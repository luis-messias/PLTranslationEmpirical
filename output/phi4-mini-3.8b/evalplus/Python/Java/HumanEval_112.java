package com.example;
import java.util.function.Predicate;

public class HumanEval_112 {

    public static Tuple<String, Boolean> reverseDelete(String s, String c) {
        Predicate<Character> isNotInC = ch -> !c.contains(String.valueOf(ch));
        
        String resultString = s.chars()
                .filter(isNotInC)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
                
        boolean isPalindrome = new StringBuilder(resultString).reverse().toString().equalsIgnoreCase(resultString);
        
        return new Tuple<>(resultString, isPalindrome);
    }

    public static void main(String[] args) {
        System.out.println(reverseDelete("abcde", "ae").getValue1()); // false
        System.out.println(reverseDelete("abcdef", "b").getValue0() + ", " + reverseDelete("abcdef", "b").getValue1()); // acdef, false
        System.out.println(reverseDelete("abcdedcba", "ab").getValue0() + ", " + reverseDelete("abcdedcba", "ab").getValue1()); // cdedc, true
    }
}

class Tuple<T, U> {
    private final T first;
    private final U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    
    public U getSecond() { return second; }
}