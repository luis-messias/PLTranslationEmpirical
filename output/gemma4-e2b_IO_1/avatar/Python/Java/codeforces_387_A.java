import java.util.Scanner;

public class codeforces_387_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first line (h1:m1)
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(":");
        int h1 = Integer.parseInt(parts1[0]);
        int m1 = Integer.parseInt(parts1[1]);

        // Read second line (h2:m2)
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(":");
        int h2 = Integer.parseInt(parts2[0]);
        int m2 = Integer.parseInt(parts2[1]);

        // Calculate total minutes for time 1
        int totalM1 = m1 + h1 * 60;

        // Calculate total minutes for time 2
        int totalM2 = m2 + h2 * 60;

        // Calculate the difference in minutes
        int diffMinutes = totalM1 - totalM2;

        // Apply modulo 1440 (minutes in a day)
        int finalMinutes = diffMinutes % 1440;

        // Convert the difference back to hours and minutes
        int finalHours = finalMinutes / 60;
        int finalMinutesPart = finalMinutes % 60;

        // Print the result in "%02d:%02d" format
        System.out.printf("%02d:%02d%n", finalHours, finalMinutesPart);
    }
}
