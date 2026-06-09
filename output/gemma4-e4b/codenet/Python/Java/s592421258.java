import java.util.Scanner;

public class s592421258 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first input (equivalent to I() for s)
        String inputA = scanner.nextLine();

        // s = I()*2 (Repeat the input string)
        String s = inputA + inputA;

        // Read the second input (equivalent to I() for the check)
        String inputB = scanner.nextLine();

        // Check if inputB is a substring of s
        boolean isInS = s.contains(inputB);

        // Print the result based on the boolean check
        if (isInS) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}