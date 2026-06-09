import java.util.Scanner;

public class s251858505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first input (equivalent to the first input() call)
        if (scanner.hasNextLine()) {
            String input1 = scanner.nextLine();

            // Read the second input (equivalent to the second input() call)
            if (scanner.hasNextLine()) {
                String input2 = scanner.nextLine();

                // The Python expression sum(map(lambda x, y:x==y, input(), input()))
                // evaluates to 1 if input1 equals input2, and 0 otherwise.
                // In Java, this is equivalent to checking equality and printing the result.
                if (input1.equals(input2)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}