package com.example;
public class HumanEval_93 {
    public static String encode(String message) {
        StringBuilder encodedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                encodedMessage.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                encodedMessage.append(Character.toUpperCase(ch));
            } else {
                encodedMessage.append(ch);
            }
        }

        for (int i = 0; i < encodedMessage.length(); i++) {
            char ch = encodedMessage.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                encodedMessage.setCharAt(i, (char) (ch + 2));
            }
        }

        return encodedMessage.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("test")); // TGST
        System.out.println(encode("This is a message")); // tHKS KS C MGSSCGG
    }
}