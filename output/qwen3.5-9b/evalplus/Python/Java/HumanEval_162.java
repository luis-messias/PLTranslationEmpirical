package com.example;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HumanEval_162 {
    /**
     * Given a string 'text', return its md5 hash equivalent string.
     * If 'text' is an empty string, return null.
     * 
     * >>> stringToMD5("Hello world") == "3e25960a79dbc69b674cd4ec67a72c62"
     */
    public static String stringToMD5(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes("UTF-8"));
            byte[] hash = md.digest();
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        } catch (Exception e) {
            throw new RuntimeException("Error computing MD5", e);
        }
    }
    
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}