import java.util.Scanner;
import java.util.Arrays;

public class s893778513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        int[] l = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            l[i] = Integer.parseInt(input[i]);
        }
        
        int b = Arrays.stream(l).max().getAsInt();
        int s = Arrays.stream(l).sum();
        
        if (b < s - b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}