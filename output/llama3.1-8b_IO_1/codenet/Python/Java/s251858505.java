import java.util.Scanner;

public class s251858505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sum(map(x -> x.equals(scanner.next()), scanner.next(), scanner.next())));
    }

    private static int sum(boolean[] bools) {
        int count = 0;
        for (boolean b : bools) {
            if (b) count++;
        }
        return count;
    }

    private static boolean[] map(Function f, String x, String y) {
        boolean[] result = new boolean[1];
        result[0] = f.apply(x, y);
        return result;
    }

    @FunctionalInterface
    interface Function {
        boolean apply(String x, String y);
    }
}
