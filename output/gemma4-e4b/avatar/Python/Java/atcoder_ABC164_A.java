import java.util.Scanner;

public class atcoder_ABC164_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                try {
                    int S = Integer.parseInt(parts[0]);
                    int W = Integer.parseInt(parts[1]);

                    if (S <= W) {
                        System.out.println("unsafe");
                    } else {
                        System.out.println("safe");
                    }
                } catch (NumberFormatException e) {
                    // Handle case where input parts are not valid integers
                }
            }
        }
        scanner.close();
    }
}