import java.util.Scanner;

public class atcoder_ABC125_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String input = scanner.nextLine().trim();
        String[] VStr = input.split(" ");
        int[] V = new int[VStr.length];
        for (int i = 0; i < VStr.length; i++) {
            if (!VStr[i].isEmpty()) {
                V[i] = Integer.parseInt(VStr[i]);
            }
        }

        input = scanner.nextLine().trim();
        String[] CStr = input.split(" ");
        int[] C = new int[CStr.length];
        for (int i = 0; i < CStr.length; i++) {
            if (!CStr[i].isEmpty()) {
                C[i] = Integer.parseInt(CStr[i]);
            }
        }

        int[] list = new int[1];
        int ans = 0;
        int X = 0;
        int Y = 0;

        for (int i = 0; i < N; i++) {
            if (V[i] - C[i] > 0) {
                X = V[i];
                Y = C[i];
                list[0]++;
                list = addElement(list, X - Y);
            }
        }

        System.out.println(sum(list));
    }

    public static int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = element;
        return newArray;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
