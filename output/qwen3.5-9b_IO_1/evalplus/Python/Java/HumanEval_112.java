public class HumanEval_112 {
    public static String[] reverseDelete(String s, String c) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (c.indexOf(ch) == -1) {
                result.append(ch);
            }
        }
        String ss = result.toString();
        String reversed = new StringBuilder(ss).reverse().toString();
        return new String[]{ss, String.valueOf(ss.equals(reversed))};
    }
}
