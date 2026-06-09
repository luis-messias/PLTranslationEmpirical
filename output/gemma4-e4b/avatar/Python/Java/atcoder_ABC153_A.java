import java.util.Scanner;

public class atcoder_ABC153_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the single line input containing h and a separated by space
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length >= 2) {
                int h = Integer.parseInt(parts[0]);
                int a = Integer.parseInt(parts[1]);
                
                // Calculate integer division (sho) and remainder (am)
                int sho = h / a;
                int am = h % a;

                // Apply ceiling logic
                if (am != 0) {
                    sho += 1;
                }

                System.out.println(sho);
            }
        }
        scanner.close();
    }
}