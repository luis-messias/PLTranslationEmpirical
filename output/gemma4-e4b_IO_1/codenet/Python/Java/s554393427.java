import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s554393427 {

    // Helper class to store the pair (value, currency)
    static class Item {
        double value;
        String currency;

        public Item(double value, String currency) {
            this.value = value;
            this.currency = currency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        // Read N
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading N

        List<Item> mo = new ArrayList<>();

        // Read N pairs of data
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length < 2) {
                continue;
            }
            
            try {
                double x = Double.parseDouble(parts[0]);
                String u = parts[1];
                mo.add(new Item(x, u));
            } catch (NumberFormatException e) {
                // Skip line if conversion fails
            }
        }
        
        scanner.close();

        double okz = 0.0;
        
        // Calculate the total
        for (Item i : mo) {
            if (i.currency.equals("JPY")) {
                okz += i.value;
            } else {
                // Apply conversion factor 380000
                okz += i.value * 380000.0;
            }
        }

        System.out.println(okz);
    }
}
