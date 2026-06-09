import java.util.Arrays;
import java.util.Scanner;

public class codeforces_299_A {
    public static int numInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] arrInput() {
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return array;
    }

    public static int[] spInput() {
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileContent = "";
        if (new File("input.txt").exists()) {
            fileContent = new String(Files.readAllBytes(Paths.get("input.txt")));
        }
        int[] a = Arrays.stream(fileContent.split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(a[0] == 1 || any(a, a[0]) ? a[0] : -1);
    }

    public static boolean any(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % n != 0) {
                return true;
            }
        }
        return false;
    }
}