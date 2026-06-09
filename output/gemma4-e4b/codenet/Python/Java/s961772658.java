import java.util.Scanner;

public class s961772658 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        for (int i = 0; i < alphabets.length; i++) {
            if (String.valueOf(alphabets[i]).equals(s)) {
                // Check bounds to prevent IndexOutOfBoundsException, replicating the intended logic 
                // while handling the case where the input is 'z'.
                if (i + 1 < alphabets.length) {
                    System.out.println(alphabets[i + 1]);
                }
            }
        }
    }
}