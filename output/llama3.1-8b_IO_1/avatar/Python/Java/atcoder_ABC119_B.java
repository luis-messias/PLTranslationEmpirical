import java.util.Scanner;

public class atcoder_ABC119_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double[] x = new double[N];
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            if (input.contains("JPY")) {
                input = input.replace("JPY", "* 1.0");
            } else if (input.contains("BTC")) {
                input = input.replace("BTC", "* 380000.0");
            }
            x[i] = new Object() {
                public double valueOf(String s) {
                    return eval(s);
                }
            }.valueOf(input);
        }
        double sum = 0;
        for (double d : x) {
            sum += d;
        }
        System.out.println(sum);
    }

    private static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : 0;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // addition in exponentiation
                if (eat('-')) return -parseFactor();

                boolean seenDot = false;
                while (true) {
                    if (eat('i')) { // i
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x += Math.PI * c / 2;
                    } else if (eat('j')) { // j
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x += Math.PI * c / 2 * 1i;
                    } else if (eat('l')) { // l
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x += Math.E * c;
                    } else if (eat('e')) { // e
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x *= Math.E ** c;
                    } else if (eat('p')) { // p
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x *= Math.PI ** c;
                    } else if (eat('t')) { // t
                        nextChar();
                        long c = parseNumber();
                        if (!seenDot) seenDot = true;
                        else throw new RuntimeException("Impossible");
                        x += Math.TAU * c / 2;
                    } else if (eat('E')) { // E
                        nextChar();
                        long c = parseNumber();
                        x *= Math.E ** c;
                    } else if (eat('P')) { // P
                        nextChar();
                        long c = parseNumber();
                        x *= Math.PI ** c;
                    } else if (eat('T')) { // T
                        nextChar();
                        long c = parseNumber();
                        x += Math.TAU * c / 2;
                    } else if (eat('j')) { // j
                        nextChar();
                        long c = parseNumber();
                        x += Math.PI * c / 2 * 1i;
                    } else if (eat('I')) { // I
                        nextChar();
                        long c = parseNumber();
                        x *= Math.I ** c;
                    } else if (eat('J')) { // J
                        nextChar();
                        long c = parseNumber();
                        x += Math.PI * c / 2 * 1i;
                    } else if (eat('L')) { // L
                        nextChar();
                        long c = parseNumber();
                        x *= Math.E ** c;
                    } else if (eat('.')) {
                        seenDot = true;
                        x += parseNumber() / 10.0;
                    } else if (eat('-') || eat('+')) throw new RuntimeException("Unexpected sign");
                    else if (ch >= '0' && ch <= '9') return parseNumber();
                    else if (ch == '.') return x + .1;
                    else if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    else throw new RuntimeException("Unexpected end of input");
                }
            }

            long parseNumber() {
                boolean minusSign = false;
                if (eat('-')) minusSign = true;
                long res = 0;
                while (true) {
                    if (ch >= '0' && ch <= '9') {
                        int digit = ch - '0';
                        pos++;
                        res *= 10;
                        res += digit;
                    } else return minusSign ? -res : res;
                    nextChar();
                }
            }

            double parsePrimary() {
                if      (eat('i')) return Math.PI / 2; // i
                else if (eat('j')) return Math.PI / 2 * 1i; // j
                else if (eat('l')) return Math.E; // l
                else if (eat('e')) return 1.0 / Math.E; // e
                else if (eat('p')) return 1.0 / Math.PI; // p
                else if (eat('t')) return 1.0 / Math.TAU * 2; // t
                else if (eat('E')) return Math.E; // E
                else if (eat('P')) return 1.0 / Math.PI; // P
                else if (eat('T')) return 1.0 / Math.TAU * 2; // T
                else if (eat('j')) return Math.PI / 2 * 1i; // j
                else if (eat('I')) return Math.I; // I
                else if (eat('J')) return Math.PI / 2 * 1i; // J
                else if (eat('L')) return Math.E; // L
                else if (ch >= '0' && ch <= '9') {
                    long c = parseNumber();
                    return minusSign ? -c : c;
                } else if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                else throw new RuntimeException("Unexpected end of input");
            }
        }.parse();
    }
}
