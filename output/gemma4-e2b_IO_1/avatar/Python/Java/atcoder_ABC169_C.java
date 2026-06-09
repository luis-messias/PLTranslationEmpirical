import java.util.Scanner;

public class atcoder_ABC169_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");

            if (parts.length >= 2) {
                // sa is the first value
                int a = Integer.parseInt(parts[0]);
                
                // sb is the second value
                double sb_val = Double.parseDouble(parts[1]);
                
                // b = int(float(sb) * 100 + 0.1)
                double bDouble = sb_val * 100.0 + 0.1;
                int b = (int) bDouble; 

                // print ( a * b // 100 )
                // Calculate a * b // 100 using long for safety
                long result = ((long) a * b) / 100;

                System.out.println(result);
            }
        }
        scanner.close();
    }
}
