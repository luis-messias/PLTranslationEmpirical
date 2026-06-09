import java.util.Scanner;

public class s199418121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length >= 2) {
                // A = int(A)
                long A = Long.parseLong(parts[0]);
                
                // B = int(B.replace(".", ""))
                String strB = parts[1];
                String cleanedB = strB.replace(".", "");
                long B = Long.parseLong(cleanedB);
                
                // print(A * B // 100)
                // Using long for calculation to prevent potential overflow
                long result = (A * B) / 100;
                
                System.out.println(result);
            }
        }
        scanner.close();
    }
}