package com.example;
public static <T extends Number> T maxElement(List<T> l) {
    if (l == null || l.isEmpty()) {
        throw new IllegalArgumentException("invalid inputs");
    }
    return Collections.max(l);
}