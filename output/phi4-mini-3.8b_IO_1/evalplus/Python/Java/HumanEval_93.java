package com.example;

public class HumanEval_93 {
    public static String encode(String message) {
        char[] switchedCaseMessage = switchCase(message);
        return new StringBuilder().append(
                vowelChange(switchedCaseMessage)
            ).toString();
    }

    private static char[] switchCase(String str) {
        final int A = Character.toUpperCase('a');
        final int a = Character.toLowerCase('A');

        for (int i = 0; i < str.length(); ++i) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || 
                (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {

                char c = Character.toLowerCase(str.charAt(i));
                int diff = A - ('a' + ((c & 0x20U) >> 5));

                if (diff == 32)
                    switchedCaseMessage[i] = str.charAt(i);
                else
                    switchedCaseMessage[i] = 'A' + diff;
            } else {
                char c = Character.toUpperCase(str.charAt(i));
                int diff = ('a' - A) * (-1);

                if (diff == 32)
                    switchedCaseMessage[i] = str.charAt(i);
                else
                    switchedCaseMessage[i] = 'A' + diff;
            }
        }

        return switchedCaseMessage;
    }

    private static char vowelChange(char ch) {
        String vowels = "aeiouAEIOU";
        
        if (vowels.indexOf(ch) != -1)
            return Character.toString((char)(ch + 2));
            
        else
            return ch;
    }
}
