package com.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_125 {

    public static Object splitWords(String txt) {
        // 1. Check for whitespace (space, newline, carriage return, tab)
        // The Python logic checks if any of these characters exist in the string.
        boolean hasWhitespace = txt.contains(" ") || txt.contains("\n") || txt.contains("\r") || txt.contains("\t");