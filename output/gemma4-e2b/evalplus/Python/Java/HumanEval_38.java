package com.example;
class CyclicEncoderDecoder {

    /**
     * Encodes a string by cycling groups of three characters.
     * @param s The input string.
     * @return The encoded string.
     */
    public static String encodeCyclic(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder encoded = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += 3) {
            // Determine the end index for the current group (up to 3 characters)
            int end = Math.min(i + 3, n);
            String group = s.substring(i, end);
            
            if (group.length() == 3) {
                // Cycle: group[1:] + group[0]
                encoded.append(group.substring(1)).append(group.charAt(0));
            } else {
                // Keep as is if length is 1 or 2
                encoded.append(group);
            }
        }
        return encoded.toString();
    }

    /**
     * Decodes a string encoded by encodeCyclic.
     * @param s The encoded string.
     * @return The decoded string.
     */
    public static String decodeCyclic(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder decoded = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += 3) {
            // Determine the end index for the current group (up to 3 characters)
            int end = Math.min(i + 3, n);
            String group = s.substring(i, end);

            if (group.length() == 3) {
                // Uncycle: group[2] + group[:2]
                decoded.append(group.charAt(2)).append(group.substring(0, 2));
            } else {
                // Keep as is if length is 1 or 2
                decoded.append(group);
            }
        }
        return decoded.toString();
    }
}