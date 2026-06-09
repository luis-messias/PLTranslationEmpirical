package com.example;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HumanEval_162 {

    /**
     * Given a string 'text', return its md5 hash equivalent string.
     * If 'text' is an empty string, return null.
     *
     * @param text The input string.
     * @return The MD5 hash as a hexadecimal string, or null if the input is empty.
     */
    public static String stringToMd5(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // This should theoretically never happen for MD5 on standard JVMs
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}