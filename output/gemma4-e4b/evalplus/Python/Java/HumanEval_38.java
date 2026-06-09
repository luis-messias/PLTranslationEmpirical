package com.example;
class CyclicEncoder {

    /**
     * returns encoded string by cycling groups of three characters.
     *
     * @param s The input string.
     * @return The encoded string.
     */
    public static String encodeCyclic(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        // Calculate number of groups: (n + 2) / 3
        int numGroups = (n + 2) / 3;

        for (int i = 0; i < numGroups; i++) {
            int start = 3 * i;
            int end = Math.min(3 * i + 3, n);
            String group = s.substring(start, end);

            if (group.length() == 3) {
                // Cycle left by 1: ABC -> BCA
                // group.substring(1) is BC
                // group.charAt(0) is A
                String encodedGroup = group.substring(1) + group.charAt(0);
                result.append(encodedGroup);
            } else {
                // Group remains unchanged if length < 3
                result.append(group);
            }
        }
        return result.toString();
    }

    /**
     * takes as input string encoded with encodeCyclic function. Returns decoded string.
     *
     * @param s The encoded input string.
     * @return The decoded string.
     */
    public static String decodeCyclic(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        // Calculate number of groups: (n + 2) / 3
        int numGroups = (n + 2) / 3;

        for (int i = 0; i < numGroups; i++) {
            int start = 3 * i;
            int end = Math.min(3 * i + 3, n);
            String group = s.substring(start, end);

            if (group.length() == 3) {
                // Cycle right by 1: BCA -> ABC
                // group.substring(2) is A
                // group.substring(0, 2) is BC
                String decodedGroup = group.substring(2) + group.substring(0, 2);
                result.append(decodedGroup);
            } else {
                // Group remains unchanged if length < 3
                result.append(group);
            }
        }
        return result.toString();
    }
}