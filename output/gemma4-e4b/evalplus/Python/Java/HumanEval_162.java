package com.example;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class HumanEval_162 {

    /**
     * Given a string 'text', return its md5 hash equivalent string.
     * If 'text' is an empty string, return null.
     *
     * @param text The input string.
     * @return The MD5 hash as a hex string, or null if the input is empty.
     */
    public static String stringToMd5(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Calculate the hash digest using UTF-8 bytes
            byte[] hashBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

            // Convert byte array to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                // Format byte as two hexadecimal characters, padding with zero if necessary
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // This should not happen as MD5 is standard
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}