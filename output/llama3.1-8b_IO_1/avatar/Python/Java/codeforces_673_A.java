import java.util.Scanner;

public class codeforces_673_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputArrStr = scanner.nextLine().split(" ");
        int[] arr = new int[inputArrStr.length];
        for (int i = 0; i < inputArrStr.length; i++) {
            arr[i] = Integer.parseInt(inputArrStr[i]);
        }
        if (arr[0] > 15) {
            System.out.println(15);
        } else {
            boolean found = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > 15) {
                    System.out.println(arr[i - 1] + 15);
                    found = true;
                    break;
                }
            }
            if (!found && arr[arr.length - 1] + 15 <= 90) {
                System.out.println(arr[arr.length - 1] + 15);
            } else if (arr[arr.length - 1] == 90 || arr[arr.length - 1] + 15 >= 90) {
                System.out.println(90);
            }
        }
    }
}
