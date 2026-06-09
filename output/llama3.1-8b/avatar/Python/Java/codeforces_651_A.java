import java.util.Scanner;

public class codeforces_651_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(Math.max(x + y - 3 + ((y - x) % 3 > 0 ? 1 : 0), 0));
        
        Scanner numScanner = new Scanner(System.in);
        Scanner arrScanner = new Scanner(System.in);
        Scanner spScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        int num() {
            return numScanner.nextInt();
        }

        int[] arr() {
            String[] input = arrScanner.nextLine().split(" ");
            int[] array = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
            return array;
        }

        int[] sp() {
            String[] input = spScanner.nextLine().split(" ");
            int[] array = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
            return array;
        }

        String str() {
            return strScanner.nextLine();
        }
    }
}