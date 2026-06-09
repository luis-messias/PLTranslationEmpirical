package com.example;
import java.security.MessageDigest;

public class HumanEval_162 {

  public static String stringToMD5(String text) {

    if (text == null || text.isEmpty()) return null;

    try {

      MessageDigest md = MessageDigest.getInstance("MD5");

      byte[] messageDigest = md.digest(text.getBytes());

      // Convert the binary data to hexadecimal format

      StringBuilder hexString = new StringBuilder();

      for (byte b : messageDigest) {
        String hex = Integer.toHexString(0xFF & b);

        if(hex.length() == 1) hexString.append('0');

        hexString.append(hex);
      }

      return hexString.toString();

    } catch (Exception e) {

      throw new RuntimeException(e);

    }

  }


  public static void main(String[] args) {

    String result = stringToMD5("Hello world");

    System.out.println(result.equals("3e25960a79dbc69b674cd4ec67a72c62"));

  }

}